package com.example.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConsumerService4 {
    private final ObjectMapper objectMapper;
    public ConsumerService4(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
//    테스트1 : 키값을 통한 파티션별 메시지 순서 보장 확인 : 서버down -> 메시지 발행 -> 서버up 테스트 진행
    @KafkaListener(
            topics = "test1-topic",
            groupId = "${spring.kafka.consumer.test1-group-id}",
            containerFactory = "kafkaListener"
    )
    public void consumer1(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            String message
    ) {
        System.out.println("key 값 : " + key);
        System.out.println("컨슈머 메시지 수신1 : " + message);
    }

}
