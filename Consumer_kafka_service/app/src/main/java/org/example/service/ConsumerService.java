package org.example.service;

import io.prometheus.client.Counter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Counter funnyCounter;
    private final Counter seriousCounter;

    public ConsumerService() {
        this.funnyCounter = Counter
                .build()
                .name("kafka_funny_events_total")
                .help("Total funny events consumed from Kafka")
                .register();

        this.seriousCounter = Counter.build()
                .name("kafka_serious_events_total")
                .help("Total serious events consumed from Kafka")
                .register();
    }

    @KafkaListener(topics = "funny", groupId = "example-group")
    public void listenFunnyTopic(String eventData) {
        try {
            System.out.println("Received funny event: " + eventData);
            funnyCounter.inc();
        } catch (Exception e) {
            System.err.println("Error processing funny event: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "serious", groupId = "example-group")
    public void listenSeriousTopic(String eventData) {
        try {
            System.out.println("Received serious event: " + eventData);
            seriousCounter.inc();
        } catch (Exception e) {
            System.err.println("Error processing serious event: " + e.getMessage());
        }
    }
}

