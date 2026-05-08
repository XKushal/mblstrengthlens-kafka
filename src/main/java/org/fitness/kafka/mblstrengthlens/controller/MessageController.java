package org.fitness.kafka.mblstrengthlens.controller;

import lombok.AllArgsConstructor;
import org.fitness.kafka.mblstrengthlens.Model.User;
import org.fitness.kafka.mblstrengthlens.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kafka/v1")
public class MessageController {

    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendStringMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish/json")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        kafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

}
