package com.example.tmdt.controller;

import com.example.tmdt.model.Message;
import com.example.tmdt.security.model.Account;
import com.example.tmdt.security.service.IAccountService;
import com.example.tmdt.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MessageController {
    @Autowired
   private IMessageService messageService;
    @Autowired
    SimpMessagingTemplate template;
    @Autowired
   private IAccountService accountService;
    //    hàm lấy tất cả list friend đã nhắn tin
    @GetMapping("/allFriend/{id}")
    public List<Message> getAllChatFriends(@PathVariable Long id){
        return messageService.initialStateAllChatFriends(id);
    }

    //    http://localhost:8080/message/all/{id}
//    trong hàm getAllMessages @PathVariable int id sẽ là người bên kia nhắn
//    và @RequestBody Account principal sẽ là chủ thể của mình đang đăng nhập
    @PostMapping( "/all/{id}")
    public List<Message> getAllMessages(@PathVariable Long id , @RequestBody Account principal) {
        String loggedInUsername = principal.getUsername();
        return messageService.getAllMessages(loggedInUsername, id);
    }

    //    @SendTo("/chat/user/queue/position-update")
//    @MessageMapping("/chat")
    @PostMapping("/chat")
    public void createPrivateChatMessages(@RequestBody Message message) throws Exception {
        if(message != null ) {
            Account account = accountService.findById(message.getFromUser().getId());
            message.setTime(LocalDateTime.now());
            message.setFromUser(account);
            messageService.save(message);
            template.convertAndSend("/chat/user/queue/position-update", message);
//            template.convertAndSend("/chat/user/queue/position-update", message);
            return;
        }
        throw new Exception("Error Create Message !");
    }
}
