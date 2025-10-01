package com.example.test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    public void kafkaMessageCreate(StudentDto dto) {
        try {
            System.out.println(dto);
            String data = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send("test1-topic", data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void kafkaMessageKeyCreate(StudentDto dto) {
        System.out.println(dto);
        kafkaTemplate.send("test1-topic","key1", dto);
    }

}
