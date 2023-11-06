package com.example.tmdt.dto;


import com.example.tmdt.model.address.Wards;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO  {
    private Long id;
    private String name;
    private Wards wards;

}
