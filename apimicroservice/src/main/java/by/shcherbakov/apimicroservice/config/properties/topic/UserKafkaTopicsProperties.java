package by.shcherbakov.apimicroservice.config.properties.topic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "topics.user")
public class UserKafkaTopicsProperties {
    private final String userFindRequest;
    private final String userFindResponse;
    private final String userSaveRequest;
}
