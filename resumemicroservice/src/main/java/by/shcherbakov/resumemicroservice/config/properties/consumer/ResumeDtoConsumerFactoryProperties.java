package by.shcherbakov.resumemicroservice.config.properties.consumer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "resumedto.consumer")
public class ResumeDtoConsumerFactoryProperties {
    private final String keyDeserializer;
    private final String valueDeserializer;
    private final String groupId;
    private final String trustedPackages;
    private final String valueDefaulType;
}
