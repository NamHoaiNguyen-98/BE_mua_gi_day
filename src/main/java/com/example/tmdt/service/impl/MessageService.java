package com.example.tmdt.service.impl;

import com.example.tmdt.model.Message;
import com.example.tmdt.repository.MessageRepository;
import com.example.tmdt.security.model.Account;
import com.example.tmdt.security.repository.IAccountRepository;
import com.example.tmdt.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public List<Message> initialStateAllChatFriends(Long loggedInUserId) {
        return messageRepository.initialStateAllChatFriends(loggedInUserId);
    }

    @Override
    public List<Message> getAllMessages(String loggedInUsername, Long chatUserId) {
        Account loggedUser = accountRepository.findByUsername(loggedInUsername);
        Account chatUser = accountRepository.findById(chatUserId).get();
        return messageRepository.findAllMessagesBetweenTwoUsers(loggedUser.getId() , chatUser.getId());
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
