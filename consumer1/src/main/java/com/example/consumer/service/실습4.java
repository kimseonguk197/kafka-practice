//package com.example.consumer.service;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class 실습4 {
//
////    테스트1. 실패된 메시지 재처리
////    기본 모드 : auto-commit
//    @KafkaListener(
//            topics = "member-topic",
//            groupId = "${spring.kafka.consumer.member-topic-log-group-id}",
//            containerFactory = "kafkaListener"
//    )
//    public void consumer1(
//            @Header(KafkaHeaders.RECEIVED_KEY) String key,
//            String message
//    ) {
//        try {
//            System.out.println("컨슈머 메시지 수신1 : " + message);
////            db작업 및 실패가능성 있는 코드
//            if(key.equals("1")){
//                throw new IllegalArgumentException("예상치 못한 예외 발생");
//            }
//            System.out.println("처리 완료");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//////    수동 커밋 모드로 변경
////    @KafkaListener(
////            topics = "member-topic",
////            groupId = "${spring.kafka.consumer.member-topic-log-group-id}",
////            containerFactory = "kafkaListener"
////    )
////    public void consumer1(
////            @Header(KafkaHeaders.RECEIVED_KEY) String key,
////            String message, Acknowledgment ack
////    ) {
////        try {
////            System.out.println("컨슈머 메시지 수신1 : " + message);
//////            db작업 및 실패가능성 있는 코드
////            if(key.equals("1")){
////                throw new IllegalArgumentException("예상치 못한 예외 발생");
////            }
////            System.out.println("처리 완료");
////            ack.acknowledge(); //수동 커밋
////        }catch (Exception e){
////            e.printStackTrace();
////            // DLQ 예시: 실패 메시지를 별도 토픽으로 발행
////            // kafkaTemplate.send("member-topic-dlq", key, message);
////        }
////    }
//}
