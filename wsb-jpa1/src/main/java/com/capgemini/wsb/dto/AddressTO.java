package com.capgemini.wsb.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressTO implements Serializable {
    private Long id;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postalCode;

}
