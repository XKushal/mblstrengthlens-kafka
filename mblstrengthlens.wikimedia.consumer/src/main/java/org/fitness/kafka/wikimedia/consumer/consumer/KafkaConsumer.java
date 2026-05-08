package org.fitness.kafka.wikimedia.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "wikimedia_topic", groupId = "fitnessGroup")
    public void consumer(String eventMessage){
        log.info("Event message received {}", eventMessage);
    }
}
