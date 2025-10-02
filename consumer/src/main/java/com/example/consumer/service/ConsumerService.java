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
//public class ConsumerService {
//    private final ObjectMapper objectMapper;
//    public ConsumerService(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
////    테스트1. 하나의 컨슈머그룹에 하나의 컨슈머가 1개의 토픽을 listen
////    테스트2. 컨슈머 서버 down → 메시지 발행 → 재시작 이후 메시지 수신 여부 확인
//    @KafkaListener(
//            topics = "test1-topic",
//            groupId = "${spring.kafka.consumer.test1-group-id}", // yml에서 불러오기
//            containerFactory = "kafkaListener"
//    )
//    public void consumer1(String message) {
//        System.out.println("컨슈머1 메시지 수신 : " + message);
//    }
//
//
//}
