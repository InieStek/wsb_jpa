package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VISIT")
@Getter
@Setter
@NoArgsConstructor
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@OneToMany(mappedBy = "visitEntity")
	private List<MedicalTreatmentEntity> medicalTreatmentEntityList;

	@ManyToOne
	private PatientEntity patientEntity;

	@ManyToOne
	private DoctorEntity doctorEntity;

}
