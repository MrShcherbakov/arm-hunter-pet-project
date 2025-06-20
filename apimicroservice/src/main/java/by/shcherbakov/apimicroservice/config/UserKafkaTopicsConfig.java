package by.shcherbakov.apimicroservice.config;

import by.shcherbakov.apimicroservice.config.properties.KafkaTopicsProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@AllArgsConstructor
public class UserKafkaTopicsConfig {

    private final KafkaTopicsProperties.UserTopicProperties topicProps;

    @Bean
    public NewTopic userFindRequest() {
        return TopicBuilder.name(topicProps.getUserFindRequest())
                .replicas(2)
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic userFindResponse() {
        return TopicBuilder.name(topicProps.getUserFindResponse())
                .replicas(2)
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic userSaveRequest() {
        return TopicBuilder.name(topicProps.getUserSaveRequest())
                .replicas(2)
                .partitions(3)
                .build();
    }

}
