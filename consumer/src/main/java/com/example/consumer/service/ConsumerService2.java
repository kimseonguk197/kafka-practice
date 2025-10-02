//package com.example.consumer.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class ConsumerService2 {
//    private final ObjectMapper objectMapper;
//    public ConsumerService2(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//    //    테스트1. 하나의 컨슈머 서버에 2개의 토픽 이상 메시지 수신
//    @KafkaListener(
//            topics = "test1-topic",
//            groupId = "${spring.kafka.consumer.test1-group-id}", // yml에서 불러오기
//            containerFactory = "kafkaListener"
//    )
//    public void consumer1(
//            String message
//    ) {
//        System.out.println("test1-topic 수신 : " + message);
//    }
//
//    @KafkaListener(
//            topics = "test2-topic",
//            groupId = "${spring.kafka.consumer.test2-group-id}",
//            containerFactory = "kafkaListener"
//    )
//    public void consumer2(String message) {
//        System.out.println("test2-topic 수신 : " + message);
//    }
//}
