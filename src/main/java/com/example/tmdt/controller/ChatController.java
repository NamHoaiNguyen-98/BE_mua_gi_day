package com.example.tmdt.controller;

import com.example.tmdt.model.Chat;
import com.example.tmdt.service.impl.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
//@RequestMapping("/api/chats")
public class ChatController {
   @Autowired
   private ChatService chatService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @PostMapping("/message")
//    public Chat createMessage(@RequestBody Chat chatMessage) {
//        chatService.save(chatMessage);
//        return chatMessage;
//    }
//
//    @MessageMapping("/websocket/message")
//    @SendTo("/topic/chat")
//    public Chat handleWebSocketMessage(Chat chatMessage) {
//        chatService.save(chatMessage);
//        return chatMessage;
//    }
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Chat receiveMessage(@Payload Chat message){
        return message;
    }
    @MessageMapping("/private-message")
    public Chat recMessage(@Payload Chat message){
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(message.getReceiverId()),"/private",message);
        chatService.save(message);
        return message;
    }
    @GetMapping("/api/{senderId}/{receiverId}")
    public List<Chat> getMessagesBetweenUsers(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return chatService.getMessagesBySenderAndReceiver(senderId, receiverId);
    }
}
