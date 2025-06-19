package by.shcherbakov.usermicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@ConfigurationProperties(prefix = "general")
public class GeneralProperties {
    private final ArrayList<String> bootstrapServers;
}
