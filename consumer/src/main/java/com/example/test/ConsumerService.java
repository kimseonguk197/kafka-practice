package com.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConsumerService {
    private final ObjectMapper objectMapper;

    public ConsumerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

//    테스트케이스1 : 토픽1개, 그룹id1개 설정 후 메시지 전송/수신확인
//    테스트케이스2 : 스프링서버down -> 메시지 발행 -> 스프링서버up 후에 메시지 수신 확인
//    테스트케이스3 : 케이스별 파티션 할당 확인 -> 컨슈머2개가 같은 그룹ID를 가지고 같은 topic을 listen 경우 -> 메시지 1개만 수신
//    테스트케이스4 : 케이스별 파티션 할당 확인 -> 컨슈머2개가 다른 그룹ID를 가지고 같은 topic을 listen 경우 -> 컨슈머그룹별로 offset관리되므로 메시지 전파 효과
//    테스트케이스5 : 메시지 순서 보장 문제 발생 확인 : 서버down -> 메시지 발행 -> 서버up
//    테스트케이스6 : 키값을 통한 파티션별 메시지 순서 보장 확인

    @KafkaListener(
            topics = "test1-topic",
            groupId = "${spring.kafka.consumer.test1-group-id}", // yml에서 불러오기
            containerFactory = "kafkaListener"
    )
    public void consumer1(String message) {
        System.out.println("컨슈머 메시지 수신1 : " + message);
    }
//    @KafkaListener(
//            topics = "test2-topic",
////            topics = "test2-topic",
//            groupId = "${spring.kafka.consumer.test2-group-id}",
//            containerFactory = "kafkaListener"
//    )
//    public void consumer2(String message) {
//        System.out.println("컨슈머 메시지 수신2 : " + message);
//    }

}
