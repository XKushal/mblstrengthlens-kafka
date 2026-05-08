package org.fitness.kafka.wikimedia.consumer;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringBootWikimediaConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(SpringBootWikimediaConsumerApplication.class);
    }
}
