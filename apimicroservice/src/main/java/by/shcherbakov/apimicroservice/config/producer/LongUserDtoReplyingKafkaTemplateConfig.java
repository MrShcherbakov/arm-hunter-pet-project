package by.shcherbakov.apimicroservice.config.producer;

import by.shcherbakov.apimicroservice.config.properties.GeneralProperties;
import by.shcherbakov.apimicroservice.config.properties.KafkaTopicsProperties;
import by.shcherbakov.apimicroservice.config.properties.consumer.UserDtoConsumerFactoryProperties;
import by.shcherbakov.apimicroservice.config.properties.producer.LongProducerFactoryProperties;
import by.shcherbakov.core_domain.dto.UserDto;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class LongUserDtoReplyingKafkaTemplateConfig {

    private final GeneralProperties genProps;
    private final KafkaTopicsProperties topicProps;
    private final LongProducerFactoryProperties prodProps;
    private final UserDtoConsumerFactoryProperties consProps;

    @Bean
    public ReplyingKafkaTemplate<String,Long, UserDto> longUserDtoReplyingKafkaTemplate(
            ProducerFactory<String,Long> pf,
            KafkaMessageListenerContainer<String,UserDto> lc
    ) {
        ReplyingKafkaTemplate<String,Long,UserDto> replyingKafkaTemplate =
                new ReplyingKafkaTemplate<>(pf,lc);
        replyingKafkaTemplate.setDefaultReplyTimeout(Duration.ofSeconds(25));

        return replyingKafkaTemplate;
    }

    @Bean
    public KafkaMessageListenerContainer<String,UserDto> userDtoListenerContainer(
            ConsumerFactory<String,UserDto> cf
    ) {
        ContainerProperties properties = new ContainerProperties(topicProps.getUserFindResponse());
        return new KafkaMessageListenerContainer<>(cf,properties);
    }

    @Bean
    public ConsumerFactory<String,UserDto> userDtoConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public ProducerFactory<String,Long> longProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    private Map<String,Object> consumerConfig() {
        Map<String,Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                genProps.getBootstrapServers());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                consProps.getKeyDeserializer());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                consProps.getValueDeserializer());
        config.put(ConsumerConfig.GROUP_ID_CONFIG,
                consProps.getGroupId());
        config.put(JsonDeserializer.TRUSTED_PACKAGES,
                consProps.getTrustedPackages());
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE,
                consProps.getValueDefaultType());

        return config;
    }

    private Map<String,Object> producerConfig() {
        Map<String,Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                genProps.getBootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                prodProps.getKeySerializer());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                prodProps.getValueSerializer());
        config.put(ProducerConfig.ACKS_CONFIG,
                prodProps.getAcks());
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,
                prodProps.isIdempotence());

        return config;
    }

}
