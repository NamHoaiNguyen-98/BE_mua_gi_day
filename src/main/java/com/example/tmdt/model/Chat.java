package com.example.tmdt.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Chat")
@EqualsAndHashCode(callSuper = false)
public class Chat{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String message;
    private Long senderId ;
    @Column(nullable = false)
    private Long receiverId;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    private Status status;
}