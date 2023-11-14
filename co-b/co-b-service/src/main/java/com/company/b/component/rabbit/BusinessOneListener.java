package com.company.b.component.rabbit;

import com.raf.framework.autoconfigure.jackson.Json;
import com.raf.framework.autoconfigure.rabbitmq.AbstractRabbitConsumerListener;
import com.raf.framework.autoconfigure.rabbitmq.RabbitMqConsumer;
import com.raf.framework.autoconfigure.rabbitmq.RabbitMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 消费者配置
 * 配置RabbitMqConsumer注解即可消费监听
 * 命名规则如下
 * ackModel 应答模式，默认手动应答，业务端不需要处理该逻辑，当监听方法出现异常会会自动回滚消息，再次消费。
 * onMessage消费逻辑 1正常 2异常（消息空->onFailure 消息正常->重写重试，onFailure）
 *
 * @author Jerry
 * @date 2019/01/01
 */
@Slf4j
@Service
@RabbitMqConsumer(queue = "xx.demo.one.queue", exchange = "xx.demo.topic", routingKey = "xx.demo.one.route")
public class BusinessOneListener extends AbstractRabbitConsumerListener {
    @Autowired
    private Json json;


    @Override
    public void onMessage(RabbitMqMessage message) {
        try {
//            isExist(message.getMsgId())
            //重复消费
            String msg = message.getMessage();
            TimeUnit.MILLISECONDS.sleep(1);
            log.info(msg);
        } catch (Exception ex) {
        }
    }

    @Override
    public void onFailure(Message msg, String error) throws Exception {
        log.error("message,错误信息{},消息体:{}", error, json.objToString(msg));
        String body = new String(msg.getBody(), StandardCharsets.UTF_8);
        RabbitMqMessage result = json.strToObj(body, RabbitMqMessage.class);
        if (Optional.ofNullable(result).isPresent()) {
//            entity.setBody(result.getMessage());
//            entity.setExchange(msg.getMessageProperties().getReceivedExchange());
//            entity.setMsgId(result.getMessage());
//            entity.setOpType(2);
//            entity.setQueue(msg.getMessageProperties().getConsumerQueue());
//            entity.setRoutingKey(msg.getMessageProperties().getReceivedRoutingKey());
//            save(entity);
        }
    }

    /**
     * 异常时可以返回true重新入队列
     *
     * @param message
     * @return
     */
    @Override
    public boolean retry(RabbitMqMessage message) {
        return false;
    }
}
