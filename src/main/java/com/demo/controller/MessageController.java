package com.demo.controller;

import com.demo.service.ReceiveMessageService;
import com.demo.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pinggang Yu on 2016/10/31.
 */
@Controller
public class MessageController {
    @Autowired
    private ReceiveMessageService receiveMessageService;
    @Autowired
    private SendMessageService sendMessageService;

    @RequestMapping("/producer")
    public String  producer(String text) {
        System.out.println(text);
        sendMessageService.sendMessage(text);
        return "redirect:index.html";
    }
    @RequestMapping("/consumer")
    public String consumer() {
        String message = receiveMessageService.receiveMessage();
        System.out.println("Receive message is: " + message);
        return "redirect:index.html";
    }
}
