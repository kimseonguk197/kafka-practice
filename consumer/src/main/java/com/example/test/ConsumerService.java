package com.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConsumerService {

//    테스트케이스1 : 파티션할당 확인 및 메시지 전송/수신확인
//    테스트케이스2 : 스프링서버down -> 메시지 발행 -> 스프링서버up 후에 메시지 수신 확인
//    테스트케이스3 : 메시지 사전에 다량 발행 후 메시지 순서 문제 발생 가능성 존재 확인
    @KafkaListener(
            topics = "test1-topic",
            groupId = "${spring.kafka.consumer.test1-group-id}", // yml에서 불러오기
            containerFactory = "kafkaListener"
    )
    public void consumer1(String message) {
        System.out.println("컨슈머 메시지 수신 : " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            StudentDto dto = objectMapper.readValue(message, StudentDto.class);
            System.out.println("dto : " + dto);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
////    테스트케이스1 : 같은 서버내 다른 토픽(test2-topic)에 다른 컨슈머그룹(test2-group-id)으로 메시지 수신 확인
////    테스트케이스2 : test1-topic으로 test2-group-id으로 메시지 수신 확인(컨슈머그룹별로 offset관리되므로 메시지 전파 효과)
//    @KafkaListener(
//            topics = "test1-topic",
//            groupId = "${spring.kafka.consumer.test1-group-id}",
//            containerFactory = "kafkaListener"
//    )
//    public void consumer2(String message) {
//        System.out.println("[test2-group] message: " + message);
//    }
}
