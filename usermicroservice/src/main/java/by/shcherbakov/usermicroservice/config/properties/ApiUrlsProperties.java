package by.shcherbakov.usermicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("url")
public class ApiUrlsProperties {
    private final String toUserUrl;
    private final String toUserdtoUrl;
}
