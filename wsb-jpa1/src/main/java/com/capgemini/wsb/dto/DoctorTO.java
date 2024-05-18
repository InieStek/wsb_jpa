package com.capgemini.wsb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorTO {

  private Long id;
  private String firstName;
  private String lastName;
  private Long telephoneNumber;
  private String email;
  private Integer doctorNumber;
  private String specialization;

}
