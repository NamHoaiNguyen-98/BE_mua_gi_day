package com.example.tmdt.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
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
    private String content;
    @ManyToOne
    private Account account ;
    @ManyToOne
    private Shop shop ;
}