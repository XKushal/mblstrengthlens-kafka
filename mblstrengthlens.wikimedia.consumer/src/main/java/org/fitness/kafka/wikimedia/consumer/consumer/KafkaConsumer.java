package org.fitness.kafka.wikimedia.consumer.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fitness.kafka.wikimedia.consumer.entity.WikimediaObj;
import org.fitness.kafka.wikimedia.consumer.repository.WikimediaDataRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {
    private WikimediaDataRepository dataRepository;

    @KafkaListener(topics = "wikimedia_topic", groupId = "fitnessGroup")
    public void consumer(String eventMessage){
        log.info("Event message received {}", eventMessage);

        WikimediaObj wikimediaObj = new WikimediaObj();
        wikimediaObj.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaObj);
    }
}
