package com.company.a.component.rabbit;

import com.raf.framework.autoconfigure.jackson.Json;
import com.raf.framework.autoconfigure.rabbitmq.AbstractRabbitSenderConfirm;
import com.raf.framework.autoconfigure.rabbitmq.RabbitMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 生产者：消息发送
 *
 * @author Jerry
 * @date 2019/01/01
 */
@Slf4j
@Component
public class RabbmitSenderConfirm extends AbstractRabbitSenderConfirm {

    @Autowired
    private Json json;

    @Override
    public void giveUp(RabbitMqMessage message, Integer replyCode, String replyText, String exchange, String routingKey) {
        log.error("消息发送失败: message:{}, replyCode:{}, replyText:{}, exchange:{}, routingKey:{}",
                json.objToString(message), replyCode, replyText, exchange, routingKey);
        if (Optional.ofNullable(message).isPresent()) {
//            entity.setBody(message.getMessage());
//            entity.setExchange(exchange);
//            entity.setMsgId(message.getMsgId());
//            entity.setOpType(1);
//            entity.setQueue("");
//            entity.setRoutingKey(routingKey);
//            entity.setError(replyText);
//            save(entity);
        }
    }
}
