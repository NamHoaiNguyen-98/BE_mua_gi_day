package com.example.tmdt.model.fkProduct;
import com.example.tmdt.security.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
@Data
@Entity
@Table(name = "Comment")
@EqualsAndHashCode(callSuper = false)
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentUser;
    private String commentShop;
    private String status;
    @ManyToOne
    private Account account ;
}
