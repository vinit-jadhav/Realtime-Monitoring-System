package org.example.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("producer")
public class MultiProducerController {

    private final String TOPIC_NAME_FUNNY = "funny";
    private final String TOPIC_NAME_SERIOUS = "serious";
    private final String BOOTSTRAP_SERVERS = "localhost:9092";  // Kafka server

    private final Producer<String, String> kafkaProducer;

    public MultiProducerController() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.kafkaProducer = new KafkaProducer<>(props);
    }

    @PostMapping("/event/funny")
    public String produceFunnyEvent() {
        sendEventToKafka(TOPIC_NAME_FUNNY, "Button Clicked: Enroll Now");
        return "Funny button click event sent to Kafka";
    }

    @PostMapping("/event/serious")
    public String produceSeriousEvent() {
        sendEventToKafka(TOPIC_NAME_SERIOUS, "Button Clicked: Buy Now");
        return "Serious button click event sent to Kafka";
    }

    private void sendEventToKafka(String topic, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "buttonClick", message);

        kafkaProducer.send(record, (metadata, exception) -> {
            if (exception != null) {
                System.err.println("Error sending message to Kafka: " + exception.getMessage());
                exception.printStackTrace();
            } else {
                System.out.println("Message sent to Kafka, offset: " + metadata.offset());
            }
        });
    }


}
