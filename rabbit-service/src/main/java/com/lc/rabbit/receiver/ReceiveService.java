package com.lc.rabbit.receiver;

import com.lc.rabbit.model.RabbitMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by liucan on 2017/3/15.
 */
@Component("appLogMessageReceiver")
public class ReceiveService extends BaseReceiver{

    public void receiveMessage(byte[] message){
        try {
            RabbitMessage messageObject = extractMessage(message);
            String type = messageObject.getType();
            System.out.println("receive message -- type:"+type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
