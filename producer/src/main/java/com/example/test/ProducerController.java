package com.example.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/message/create")
    public void orderCreate(@RequestBody StudentDto dto){
        producerService.kafkaMessageCreate(dto);
    }

}
