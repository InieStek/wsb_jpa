package com.capgemini.wsb.persistence.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	@ManyToMany(mappedBy = "addressEntity")
	private List<DoctorEntity> doctorEntity;

	@ManyToMany(mappedBy = "addressEntity")
	private List<PatientEntity> patientEntity;

}
