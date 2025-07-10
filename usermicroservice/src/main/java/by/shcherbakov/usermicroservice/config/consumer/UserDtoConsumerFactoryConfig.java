package by.shcherbakov.usermicroservice.config.consumer;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.usermicroservice.config.properties.KafkaProperties;
import by.shcherbakov.usermicroservice.config.properties.consumer.UserDtoConsumerFactoryProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class UserDtoConsumerFactoryConfig {

    private final UserDtoConsumerFactoryProperties consProps;
    private final KafkaProperties kafkaProps;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,UserDto> userDtoContainerFactory(
            ConsumerFactory<String,UserDto> cf
    ) {
        ConcurrentKafkaListenerContainerFactory<String,UserDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setConsumerFactory(cf);
        return factory;
    }

    @Bean
    public ConsumerFactory<String,UserDto> userDtoConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    public Map<String,Object> consumerConfig() {
        Map<String,Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaProps.getBootstrapServers());
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

}
