package com.example.tmdt.repository;

import com.example.tmdt.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query(value = "SELECT * FROM chat WHERE sender_id = :senderId AND receiver_id = :receiverId", nativeQuery = true)
    List<Chat> findBySenderAndReceiver(@Param("senderId") Long senderId,
                                       @Param("receiverId") Long receiverId);

    @Query(value = "SELECT * FROM chat where sender_id = :senderId", nativeQuery = true)
    List<Chat> findListReceiverBySender(@Param("senderId") Long senderId);
}
