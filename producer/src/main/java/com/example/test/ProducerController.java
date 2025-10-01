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
    public void messageCreate(@RequestBody StudentDto dto){
        producerService.kafkaMessageCreate(dto);
    }
    @PostMapping("/message/create/key")
    public void messageCreateKey(@RequestBody StudentDto dto){
        producerService.kafkaMessageKeyCreate(dto);
    }

}
