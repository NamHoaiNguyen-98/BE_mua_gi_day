package com.example.tmdt.dto;

import com.example.tmdt.model.Discount;

import com.example.tmdt.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id ;
    private String name ;
    private String avatar ;
    private String gender ;
    private LocalDate age ;
    private String phone ;
    private String email ;
    private String address ;
    private WardsDTO wards;
    private Discount discount ;
    private Account account ;
    private Integer changeRole ;
}