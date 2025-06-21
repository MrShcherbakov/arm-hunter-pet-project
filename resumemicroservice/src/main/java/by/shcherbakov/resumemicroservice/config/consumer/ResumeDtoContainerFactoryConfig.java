package by.shcherbakov.resumemicroservice.config.consumer;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.resumemicroservice.config.properties.consumer.ResumeDtoConsumerFactoryProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class ResumeDtoContainerFactoryConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private final ArrayList<String> bootstrapServer;
    private final ResumeDtoConsumerFactoryProperties consProps;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,ResumeDto> resumeDtoContainerFactory(
            ConsumerFactory<String,ResumeDto> cf
    ) {
        ConcurrentKafkaListenerContainerFactory<String,ResumeDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cf);
        return factory;
    }

    @Bean
    public ConsumerFactory<String,ResumeDto> resumeDtoConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    private Map<String,Object> consumerConfig() {
        Map<String,Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServer);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                consProps.getKeyDeserializer());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                consProps.getValueDeserializer());
        config.put(ConsumerConfig.GROUP_ID_CONFIG,
                consProps.getGroupId());
        config.put(JsonDeserializer.TRUSTED_PACKAGES,
                consProps.getTrustedPackages());
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE,
                consProps.getValueDefaulType());

        return config;
    }
}
