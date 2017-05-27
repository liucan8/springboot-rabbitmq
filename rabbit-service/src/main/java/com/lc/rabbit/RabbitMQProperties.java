/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lc.rabbit;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbitMQ")
public class RabbitMQProperties {

    private String host;
    private int port;
    private String vhost;
    private String username;
    private String password;
    private String logQueue;
    private String logRouteKey;
    private String appExchange;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogQueue() {
        return logQueue;
    }

    public void setLogQueue(String logQueue) {
        this.logQueue = logQueue;
    }

    public String getLogRouteKey() {
        return logRouteKey;
    }

    public void setLogRouteKey(String logRouteKey) {
        this.logRouteKey = logRouteKey;
    }

    public String getAppExchange() {
        return appExchange;
    }

    public void setAppExchange(String appExchange) {
        this.appExchange = appExchange;
    }
}
