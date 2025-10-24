//package com.example.consumer.service;
//
//import com.example.consumer.dtos.MemberDto;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Transactional
//public class 실습3 {
//    private final ObjectMapper objectMapper;
//    private static Map<String, List<MemberDto>> map = new HashMap<>();
//    public 실습3(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
////    테스트1. 키값을 통한 파티션별 메시지 순서 보장 확인 : 서버down -> 메시지 발행 -> 서버up 테스트 진행
//    @KafkaListener(
//            topics = "member-topic",
//            groupId = "${spring.kafka.consumer.member-topic-log-group-id}",
//            containerFactory = "kafkaListener"
//    )
//    public void consumer1(
//            @Header(KafkaHeaders.RECEIVED_KEY) String key,
//            String message
//    ) {
//        System.out.println("key 값 : " + key);
//        System.out.println("컨슈머 메시지 수신 : " + message);
//        try {
//            MemberDto memberDto = objectMapper.readValue(message, MemberDto.class);
//            if(!map.containsKey(key)){
//                map.put(key, new ArrayList<>());
//                map.get(key).add(memberDto);
//            }else {
//                map.get(key).add(memberDto);
//            }
//            System.out.println("map : " + map);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
