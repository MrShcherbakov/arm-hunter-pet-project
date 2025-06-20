package by.shcherbakov.apimicroservice.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("kafkaTopicsProperties")
@AllArgsConstructor
public class KafkaTopicsProperties {

    private final ResumeTopicProperties resumeProps;
    private final UserTopicProperties userProps;

    @Data
    @ConfigurationProperties(prefix = "topics.resume")
    public static class ResumeTopicProperties {
        private final String resumeSaveRequest;
    }

    @Data
    @ConfigurationProperties(prefix = "topics.user")
    public static class UserTopicProperties {
        private final String userFindRequest;
        private final String userFindResponse;
        private final String userSaveRequest;
    }
}
