package by.shcherbakov.apimicroservice.config.properties.producer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "long.producer")
public class LongProducerFactoryProperties {
    private final String keySerializer;
    private final String valueSerializer;
    private final String acks;
    private final boolean idempotence;
}
