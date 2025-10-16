//package org.example.controller;
//
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Properties;
//
//@RestController
//@RequestMapping("/producer")
//public class ProducerController {
//
//    private final String TOPIC_NAME = "funny";
//    private final String BOOTSTRAP_SERVERS = "localhost:9092";  // Kafka server
//
//    private final Producer<String, String> kafkaProducer;
//
//    public ProducerController() {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        this.kafkaProducer = new KafkaProducer<>(props);
//    }
//
//    @RequestMapping("/event")
//    public void produceEventToKafka(@RequestBody String eventData) {
//        ProducerRecord<String,String> record = new ProducerRecord(TOPIC_NAME, "userEvent", eventData);
//
//        kafkaProducer.send(record, (metadata, exception) -> {
//            if(exception != null) {
//                System.err.println("Error sending message to kafka"+exception.getMessage());
//                exception.printStackTrace();
//            } else {
//                System.out.println("Message sent to Kafka, offset: " + metadata.offset());
//            }
//        });
//
//
//
//    }
//
//
//
//}
