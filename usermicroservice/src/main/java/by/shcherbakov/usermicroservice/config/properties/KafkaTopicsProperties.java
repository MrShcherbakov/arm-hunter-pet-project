package by.shcherbakov.usermicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("kafkaTopicsProperties")
@ConfigurationProperties(prefix = "kafka.topics")
public class KafkaTopicsProperties {
    private String userFindRequest;
    private String userFindResponse;
}
