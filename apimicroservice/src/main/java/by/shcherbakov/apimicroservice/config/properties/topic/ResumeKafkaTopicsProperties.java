package by.shcherbakov.apimicroservice.config.properties.topic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "topics.resume")
public class ResumeKafkaTopicsProperties {
    private final String resumeSaveRequest;
    private final String resumeDeleteRequest;
}
