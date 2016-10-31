package com.demo.service.impl;

import com.demo.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Pinggang Yu on 2016/10/31.
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendMessage(final String message) {
        String destination = jmsTemplate.getDefaultDestination().toString();
        if (destination != null) {
            System.out.println("destination is "+destination);
        } else {
            System.out.println("destination is null");
        }
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
