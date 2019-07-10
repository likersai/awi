package xyz.likersai.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import xyz.likersai.demo.websocket.LikersaiMessage;
import xyz.likersai.demo.websocket.LikersaiResponse;

import java.security.Principal;

@Controller
/**
 * @program: awi
 * @description: WebSocket控制器
 * @author: sun.ye
 * @create: 2019-05-04 18:00
 */
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public LikersaiResponse say(LikersaiMessage message) throws Exception{
        Thread.sleep(3000);
        return new LikersaiResponse("Likersai" + message.getName());
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if (principal.getName().equals("likersai")){
            messagingTemplate.convertAndSendToUser("likeryui","/queue/notifications",principal.getName() +  "-send:" + msg);
        }else {
            messagingTemplate.convertAndSendToUser("likersai","/queue/notifications",principal.getName() +  "-send:" + msg);
        }
    }

}