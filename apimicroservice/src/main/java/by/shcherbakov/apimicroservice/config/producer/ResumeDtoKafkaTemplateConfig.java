package by.shcherbakov.apimicroservice.config.producer;

import by.shcherbakov.apimicroservice.config.properties.KafkaProperties;
import by.shcherbakov.apimicroservice.config.properties.producer.ResumeDtoProducerFactoryProperties;
import by.shcherbakov.core_domain.dto.ResumeDto;
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
public class ResumeDtoKafkaTemplateConfig {

    private final KafkaProperties kafkaProps;
    private final ResumeDtoProducerFactoryProperties prodProps;

    @Bean
    public KafkaTemplate<String,ResumeDto> resumeDtoKafkaTemplate(
            ProducerFactory<String,ResumeDto> pf
    ) {
        return new KafkaTemplate<>(pf);
    }

    @Bean
    public ProducerFactory<String,ResumeDto> resumeDtoProducerFactory() {
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
