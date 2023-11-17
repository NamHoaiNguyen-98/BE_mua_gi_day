package com.example.tmdt.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data

@Entity
@Table(name = "Image")
@EqualsAndHashCode(callSuper = false)
public class Image {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

