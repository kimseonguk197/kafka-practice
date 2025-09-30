package com.example.test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void kafkaMessageCreate(StudentDto dto) {
        kafkaTemplate.send("test1-topic", dto);
        kafkaTemplate.send("test2-topic", dto);
    }
    public void kafkaMessageKeyCreate(StudentDto dto) {
        kafkaTemplate.send("test1-topic", dto);
    }

}
