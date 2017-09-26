package com.seerh.springboot.controller;

import com.seerh.springboot.domain.WSMessage;
import com.seerh.springboot.domain.WSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class WSController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WSResponse say(WSMessage message) throws Exception {
        Thread.sleep(3000);
        return new WSResponse("Welcome, " + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if(principal.getName().equals("abc")) {
            simpMessagingTemplate.convertAndSendToUser("xyz", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        } else {
            simpMessagingTemplate.convertAndSendToUser("abc", "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }
    }

    @RequestMapping("ws")
    public String ws() {
        return "ws";
    }

    @RequestMapping("chat")
    public String chat() {
        return "chat";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
