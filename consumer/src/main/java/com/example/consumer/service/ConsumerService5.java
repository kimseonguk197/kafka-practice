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
//public class ConsumerService5 {
//    private final ObjectMapper objectMapper;
//    public ConsumerService5(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
////    테스트1 : 실패된 메시지 재처리
//
//    @KafkaListener(
//            topics = "test1-topic",
//            groupId = "${spring.kafka.consumer.test1-group-id}", // yml에서 불러오기
//            containerFactory = "kafkaListener"
//    )
//    public void consumer1(
//            String message
//            , Acknowledgment ack
//    ) {
//        try {
//            System.out.println("컨슈머 메시지 수신1 : " + message);
////            db작업 및 실패가능성 있는 코드
////            if(true){
////                throw new IllegalArgumentException("예상치 못한 예외 발생");
////            }
//            ack.acknowledge(); //수동 커밋
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
