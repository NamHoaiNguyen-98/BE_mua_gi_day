package com.example.tmdt.model.buyPrd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "confirm")
@EqualsAndHashCode(callSuper = false)
public class Confirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
