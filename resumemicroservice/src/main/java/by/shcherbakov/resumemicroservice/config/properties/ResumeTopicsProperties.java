package by.shcherbakov.resumemicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("resumeTopicsProperties")
@ConfigurationProperties(prefix = "topics.resume")
public class ResumeTopicsProperties {
    private String resumeSaveRequest;
}
