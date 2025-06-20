package by.shcherbakov.usermicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component("kafkaProperties")
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
    private ArrayList<String> bootstrapServers;
}
