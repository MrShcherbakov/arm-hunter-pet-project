package by.shcherbakov.apimicroservice.config;

import by.shcherbakov.apimicroservice.config.properties.KafkaTopicsProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@AllArgsConstructor
public class ResumeKafkaTopicsConfig {

    private final KafkaTopicsProperties.ResumeTopicProperties topicProps;

    @Bean
    public NewTopic saveResume() {
        return TopicBuilder.name(topicProps.getResumeSaveRequest())
                .replicas(2)
                .partitions(3)
                .build();
    }
}
