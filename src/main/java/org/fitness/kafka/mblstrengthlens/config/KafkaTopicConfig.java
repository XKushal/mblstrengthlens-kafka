package org.fitness.kafka.mblstrengthlens.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic strengthLensStringTopic(){
        return TopicBuilder.name("strengthlens_string_topic")
                .build();
    }

    @Bean
    public NewTopic strengthLensJsonTopic(){
        return TopicBuilder.name("strengthlens_json_topic")
                .build();
    }
}
