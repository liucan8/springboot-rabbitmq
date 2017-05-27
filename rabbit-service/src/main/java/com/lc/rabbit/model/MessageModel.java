package com.lc.rabbit.model;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/15.
 */
public class MessageModel {
    private String name;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public byte[] getBytes(){
        Map map = new HashMap();
        map.put("name",this.getName());
        map.put("mobile",this.getMobile());
        return JSON.toJSONString(map).getBytes();
    }
}
