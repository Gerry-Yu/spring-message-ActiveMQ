package com.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Pinggang Yu on 2016/10/31.
 */
@Service
public class QueueMessageListener implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("From listener,message is "+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
