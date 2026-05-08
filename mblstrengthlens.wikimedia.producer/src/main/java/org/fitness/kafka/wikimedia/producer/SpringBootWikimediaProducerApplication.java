package org.fitness.kafka.wikimedia.producer;

import lombok.AllArgsConstructor;
import org.fitness.kafka.wikimedia.producer.producer.KafkaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringBootWikimediaProducerApplication implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(SpringBootWikimediaProducerApplication.class);
    }

    private KafkaProducer kafkaProducer;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner started");
        kafkaProducer.sendMessage();
    }
}
