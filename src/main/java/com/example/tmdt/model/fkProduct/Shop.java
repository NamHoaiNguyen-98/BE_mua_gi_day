package com.example.tmdt.model.fkProduct;
import com.example.tmdt.model.address.Address;
import com.example.tmdt.security.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
@Data
@Entity
@Table(name = "Shop")
@EqualsAndHashCode(callSuper = false)
public class Shop  {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    private String phone;
    @ManyToOne
    private Account account ;
    @ManyToOne
    private Address address ;
}
