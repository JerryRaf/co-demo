package com.company.a.controller;

import com.company.a.service.RabbitMqServiceImpl;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @date 2019/01/01 12:00
 */
@Slf4j
@RequestMapping("/rabbitMq")
@RestController
public class RabbitMqController {

    private final RabbitMqServiceImpl rabbitMqService;

    public RabbitMqController(RabbitMqServiceImpl rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @GetMapping("/send1")
    public RafResult<?> send1(String msg) {
        rabbitMqService.send1(msg);
        return RafResult.success();
    }

    @GetMapping("/send2")
    public RafResult<?> send2(String msg) {
        rabbitMqService.send2(msg);
        return RafResult.success();
    }

    @GetMapping("/delay1")
    public RafResult<?> delay1(String msg, Integer second) {
        rabbitMqService.delay1(msg, second);
        return RafResult.success();
    }

    @GetMapping("/delay2")
    public RafResult<?> delay2(String msg, Integer second) {
        rabbitMqService.delay2(msg, second);
        return RafResult.success();
    }
}
