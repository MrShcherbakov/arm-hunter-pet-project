package by.shcherbakov.usermicroservice.config.producer;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.usermicroservice.config.properties.KafkaProperties;
import by.shcherbakov.usermicroservice.config.properties.producer.UserDtoProducerFactoryProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class UserDtoKafkaTemplateConfig {

    private final KafkaProperties kafkaProps;
    private final UserDtoProducerFactoryProperties prodProps;

    @Bean
    public KafkaTemplate<String, UserDto> userDtoKafkaTemplate(
            ProducerFactory<String,UserDto> pf
    ) {
        return new KafkaTemplate<>(pf);
    }

    @Bean
    public ProducerFactory<String,UserDto> userDtoProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    private Map<String,Object> producerConfig() {
        Map<String,Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaProps.getBootstrapServers());
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
