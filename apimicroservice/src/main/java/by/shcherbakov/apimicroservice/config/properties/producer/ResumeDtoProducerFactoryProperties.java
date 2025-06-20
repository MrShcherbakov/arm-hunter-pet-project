package by.shcherbakov.apimicroservice.config.properties.producer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "resumedto.producer")
public class ResumeDtoProducerFactoryProperties {
    private final String keySerializer;
    private final String valueSerializer;
    private final String acks;
    private final boolean idempotence;
}
