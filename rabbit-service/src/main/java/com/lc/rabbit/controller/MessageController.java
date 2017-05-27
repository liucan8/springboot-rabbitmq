package com.lc.rabbit.controller;

import com.lc.rabbit.sender.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/15.
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private SendService sendService;
    @RequestMapping(value="/message",method = RequestMethod.GET)
    public void test(){
        try {
            sendService.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
