/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lc.rabbit.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.rabbit.model.RabbitMessage;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class BaseReceiver {

    ObjectMapper objectMapper = new ObjectMapper();

    public abstract void receiveMessage(byte[] message);

    public RabbitMessage extractMessage(byte[] bytes) throws UnsupportedEncodingException, IOException {
        String string = new String(bytes, "utf-8");
        if (!string.contains("uploadAuthorization")) {
            System.out.println("Received message :" + string);
        }
        return objectMapper.readValue(string, RabbitMessage.class);
    }
}
