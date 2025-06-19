package by.shcherbakov.usermicroservice.config.properties.producer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "user.producer")
public class UserDtoProducerFactoryProperties {
    private final String keySerializer;
    private final String valueSerializer;
    private final String acks;
    private final boolean idempotence;
}
