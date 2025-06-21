package by.shcherbakov.resumemicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "url")
public class ApiUrlsProperties {
    private final String toResumeUrl;
    private final String toResumedtoUrl;
}
