package com.example.tmdt.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "User")
@EqualsAndHashCode(callSuper = false)
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    @ManyToOne
    private Wards wards;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Boolean isAccountNonLocked;

}
