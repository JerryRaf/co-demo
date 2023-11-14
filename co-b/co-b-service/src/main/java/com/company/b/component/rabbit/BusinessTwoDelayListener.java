package com.company.b.component.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者配置
 * 业务2延迟监听队列
 *
 * @author Jerry
 * @date 2019/01/01
 */
@Slf4j
@Component
@RabbitListener(queues = "xx.demo.delay.businessTwo.receive.queue")
public class BusinessTwoDelayListener {

    @RabbitHandler
    public void process(String content) {
        log.info(content);
    }
}