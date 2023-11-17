package com.example.tmdt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Shop")
@EqualsAndHashCode(callSuper = false)
public class Shop extends Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private String address;
    @ManyToOne
    private Wards wards;
}
