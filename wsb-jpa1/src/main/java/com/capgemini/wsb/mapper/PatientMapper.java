package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public final class PatientMapper {

  public static PatientTO mapToTO(final PatientEntity patientEntity) {
    if (patientEntity == null) {
      return null;
    }
    final PatientTO patientTO = new PatientTO();
    patientTO.setId(patientEntity.getId());
    patientTO.setFirstName(patientEntity.getFirstName());
    patientTO.setLastName(patientEntity.getLastName());
    patientTO.setEmail(patientEntity.getEmail());
    patientTO.setPatientNumber(patientEntity.getPatientNumber());
    patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
    patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
    return patientTO;
  }

  public static PatientEntity mapToEntity(final PatientTO patientTO) {
    if (patientTO == null) {
      return null;
    }
    final PatientEntity patientEntity = new PatientEntity();
    patientEntity.setId(patientTO.getId());
    patientEntity.setFirstName(patientTO.getFirstName());
    patientEntity.setLastName(patientTO.getLastName());
    patientEntity.setEmail(patientTO.getEmail());
    patientEntity.setPatientNumber(patientTO.getPatientNumber());
    patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
    patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
    return patientEntity;
  }
}
