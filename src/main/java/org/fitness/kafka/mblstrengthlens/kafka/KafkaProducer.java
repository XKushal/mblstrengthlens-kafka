package org.fitness.kafka.mblstrengthlens.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fitness.kafka.mblstrengthlens.Model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaStringTemplate;
    private KafkaTemplate<String, User> kafkaJsonTemplate;

    public void sendStringMessage(String message){
        log.info("String Message sent {}", message);
        kafkaStringTemplate.send("strengthlens_string_topic", message);
    }

    public void sendJsonMessage(User data){
        log.info("Json Message sent {}", data.toString());
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "strengthlens_json_topic")
                .build();
        kafkaJsonTemplate.send(message);
    }
}
