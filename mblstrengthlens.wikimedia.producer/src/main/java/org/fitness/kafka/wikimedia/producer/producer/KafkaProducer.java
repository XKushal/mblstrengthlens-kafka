package org.fitness.kafka.wikimedia.producer.producer;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.HttpConnectStrategy;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fitness.kafka.wikimedia.producer.handler.EventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException, StreamException {
        String topic = "wikimedia_topic";
        //to read real time stream data from wikimedia, we use event source
        EventHandler eventHandler = new EventHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        HttpConnectStrategy connectStrategy = HttpConnectStrategy.http(URI.create(url))
                .header("User-Agent", "mblstrengthlens-kafka-producer/1.0 (support@strengthlens.com)");
        EventSource.Builder eventSource = new EventSource.Builder(connectStrategy);

        BackgroundEventSource backgroundEventSource =
                new BackgroundEventSource.Builder(eventHandler, eventSource).build();

        backgroundEventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
