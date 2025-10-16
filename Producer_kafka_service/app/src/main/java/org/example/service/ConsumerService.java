//package org.example.service;
//
//import io.prometheus.client.Counter;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConsumerService {
//
//    private final Counter kafkaCounter;
//
//    public ConsumerService(){
//        this.kafkaCounter = Counter.build()
//                .name("total_messages_consumed")
//                .help("Total messages consumed from Kafka")
//                .register();
//    }
//
//    @KafkaListener(topics = "funny")
//    public void listen(String eventData){
//        System.out.println("Received event message: "+eventData);
//        kafkaCounter.inc();
//    }
//
//}
