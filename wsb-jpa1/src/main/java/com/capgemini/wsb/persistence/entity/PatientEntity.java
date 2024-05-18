package com.capgemini.wsb.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PATIENT")
@Getter
@Setter
@NoArgsConstructor
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	private String firstName;
	private String lastName;
	private BigDecimal telephoneNumber;
	private String email;
	private String patientNumber;
	private LocalDate dateOfBirth;
	private Integer age;

	@OneToMany(mappedBy = "patientEntity")
	private List<VisitEntity> visitEntity;

	@ManyToMany
	private List<AddressEntity> addressEntity;

}
