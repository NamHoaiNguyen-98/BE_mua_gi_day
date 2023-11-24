package com.example.tmdt.service.impl;

import com.example.tmdt.model.Chat;
import com.example.tmdt.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    public ChatRepository chatRepository;

    public Chat save(Chat chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());
        return chatRepository.save(chatMessage);
    }

    public List<Chat> getAllMessages() {
        return chatRepository.findAll();
    }

    public List<Chat> getMessagesBySenderAndReceiver(Long senderId, Long receiverId) {
            return chatRepository.findBySenderAndReceiver(senderId, receiverId);
    }
    public List<Long> findListReceiverId(Long senderId) {
        List<Chat> chats = chatRepository.findListReceiverBySender(senderId);
        List<Long> receiverIds = new ArrayList<>();
        Long receiverId = chats.get(0).getReceiverId();
        receiverIds.add(receiverId);
        for (Chat chat : chats) {
            if(!chat.getReceiverId().equals(receiverId)) {
                receiverIds.add(chat.getReceiverId());
            }

        } return receiverIds;
    }
}
