package org.fitness.kafka.mblstrengthlens.kafka;

import lombok.extern.slf4j.Slf4j;
import org.fitness.kafka.mblstrengthlens.Model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "strengthlens_string_topic", groupId = "fitnessGroup")
    public void consume(String message){
        log.info("Message received {}", message);
    }

    @KafkaListener(topics = "strengthlens_json_topic", groupId = "fitnessGroup")
    public void consume(User user){
        log.info("JSON message received {}", user);
    }
}
