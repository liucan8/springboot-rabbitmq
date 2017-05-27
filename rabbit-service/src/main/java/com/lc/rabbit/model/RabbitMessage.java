/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lc.rabbit.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RabbitMessage {

    ObjectMapper objectMapper = new ObjectMapper();
    private String type;
    private String content;

    public RabbitMessage(String type, Object content) throws JsonProcessingException {
        this.type = type;
        this.content = objectMapper.writeValueAsString(content);
    }

    public RabbitMessage(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public RabbitMessage() {

    }

    public byte[] getBytes() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("content", content);
        return objectMapper.writeValueAsString(map).getBytes();
    }

    public String getType() {
        return type;
    }

    public <T> T getContent(Class<T> clz) throws IOException {
        String content1 = this.content;
        return objectMapper.readValue(content1, clz);
    }

//    public String getContent() {
//        return content;
//    }

//    public void setContent(Object content1) throws JsonProcessingException {
//        this.content = objectMapper.writeValueAsString(content1);
//    }

    public void setContent(String content) {
        this.content = content;
    }

}
