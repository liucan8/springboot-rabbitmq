package com.lc.rabbit.controller;

import com.alibaba.fastjson.JSON;
import com.lc.rabbit.model.MessageModel;

/**
 * Created by Administrator on 2017/3/15.
 */
public class Test {
    public static void main(String args[]) {
        /*MessageModel messageModel = new MessageModel();
        messageModel.setMobile("110");
        messageModel.setName("police");

        String str = JSON.toJSONString(messageModel);
        byte[] bytes = str.getBytes();*/
        swtest();
        System.out.println("");
    }

    public static void swtest(){
        switch ("test") {
            case "test":
                System.out.println("1");
                break;
            case "1":
                System.out.println("2");
                break;
            default:
                System.out.println("3");
        }
    }
}
