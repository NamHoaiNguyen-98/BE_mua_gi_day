package com.example.tmdt.service;

import com.example.tmdt.model.Message;

import java.util.List;

public interface IMessageService{
    List<Message> initialStateAllChatFriends(Long loggedInUserId);
    List<Message> getAllMessages(String loggedInUsername, Long chatUserId);
    Message save(Message message);
}
