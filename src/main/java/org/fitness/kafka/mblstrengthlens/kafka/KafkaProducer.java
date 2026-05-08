package org.fitness.kafka.mblstrengthlens.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Message sent {}", message);
        kafkaTemplate.send("strengthlens-workout", message);
    }
}
