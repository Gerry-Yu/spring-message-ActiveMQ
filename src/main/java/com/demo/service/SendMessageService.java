package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by Pinggang Yu on 2016/10/31.
 */
public interface SendMessageService {
    void sendMessage(String message);
}
