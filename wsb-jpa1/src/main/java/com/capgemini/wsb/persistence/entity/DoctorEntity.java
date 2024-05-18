package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	private String firstName;

	private String lastName;

	private String telephoneNumber;

	private String email;

	private String doctorNumber;

	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@OneToMany(mappedBy = "doctorEntity")
	private List<VisitEntity> visitEntity;

	@ManyToMany
	private List<AddressEntity> addressEntity;


}
