package com.example.tmdt.model;
import com.example.tmdt.model.address.Address;
import javax.persistence.*;

import com.example.tmdt.security.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
@Table(name = "User")
@EqualsAndHashCode(callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String avatar ;
    private String gender ;
    private Integer age ;
    private String phone ;
    @ManyToOne
    private Address address ;
    @ManyToOne
    private Discount discount ;
    @OneToOne
    private Account account ;
    @Column(columnDefinition = "integer default 0")
    private Integer changeRole ;

}
