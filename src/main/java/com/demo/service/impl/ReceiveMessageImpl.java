package com.demo.service.impl;

import com.demo.service.ReceiveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
/**
 * Created by Pinggang Yu on 2016/10/31.
 */
@Service
public class ReceiveMessageImpl implements ReceiveMessageService{
    @Autowired
    private JmsTemplate jmsTemplate;

    public String receiveMessage() {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        try {
            return textMessage.getText();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }

    }
}
