package com.lc.rabbit.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lc.rabbit.RabbitMQProperties;
import com.lc.rabbit.model.MessageModel;
import com.lc.rabbit.model.RabbitMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service
public class SendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQProperties properties;

    public void sendMessage(){
        try {
            RabbitMessage rabbitMessage = new RabbitMessage("liucan", "liucan is login...");
            Message message = MessageBuilder.withBody(rabbitMessage.getBytes()).build();
            //参数是 routeKey和对应的数据
            rabbitTemplate.send(properties.getLogRouteKey(), message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
