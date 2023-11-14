package com.company.a.service;

import cn.hutool.core.util.IdUtil;
import com.raf.framework.autoconfigure.rabbitmq.RabbitMqMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * rabbitMq普通消息发送及延迟固定时间消息发送示例
 *
 * @author Jerry
 * @date 2019/01/01
 */
@Slf4j
@Service
public class RabbitMqServiceImpl {
    private final RabbitMqMessageSender rabbitMqMessageSender;

    public RabbitMqServiceImpl(RabbitMqMessageSender rabbitMqMessageSender) {
        this.rabbitMqMessageSender = rabbitMqMessageSender;
    }

    /**
     * 普通消息业务1
     *
     * @param msg
     */
    public void send1(String msg) {
        rabbitMqMessageSender.send(IdUtil.simpleUUID(), msg, "xx.demo.one.route");
    }

    /**
     * 普通消息业务2
     *
     * @param msg
     */
    public void send2(String msg) {
        rabbitMqMessageSender.send(IdUtil.simpleUUID(), msg, "xx.demo.two.route");
    }

    /**
     * 延迟消息业务1
     *
     * @param msg
     */
    public void delay1(String msg, Integer second) {
        rabbitMqMessageSender.sendDelay(IdUtil.simpleUUID(), msg, "xx.demo.delay.businessOne", second);
        log.info("发送成功delay1");
    }

    /**
     * 延迟消息业务2
     *
     * @param msg
     */
    public void delay2(String msg, Integer second) {
        rabbitMqMessageSender.sendDelay(IdUtil.simpleUUID(), msg, "xx.demo.delay.businessTwo", second);
        log.info("发送成功delay2");
    }
}
