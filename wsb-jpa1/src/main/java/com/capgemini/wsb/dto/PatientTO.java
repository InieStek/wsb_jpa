package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientTO implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
  private BigDecimal telephoneNumber;
  private String email;
  private String patientNumber;
  private LocalDate dateOfBirth;
  private List<VisitTO> visits;
  private Integer age;
}
