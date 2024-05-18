package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {

  public static VisitTO mapToTO(final VisitEntity visitEntity) {
    if (visitEntity == null) {
      return null;
    }
    final VisitTO visitTO = new VisitTO();
    visitTO.setId(visitEntity.getId());
    visitTO.setDescription(visitEntity.getDescription());
    visitTO.setTime(visitEntity.getTime());
    visitTO.setPatient(visitEntity.getPatientEntity());
    visitTO.setDoctor(visitEntity.getDoctorEntity());
    visitTO.setMedicalTreatments(visitEntity.getMedicalTreatmentEntityList());
    return visitTO;
  }

  public static VisitEntity mapToEntity(final VisitTO visitTO) {
    if (visitTO == null) {
      return null;
    }
    final VisitEntity visitEntity = new VisitEntity();
    visitEntity.setId(visitTO.getId());
    visitEntity.setDescription(visitTO.getDescription());
    visitEntity.setTime(visitTO.getTime());
    visitEntity.setPatientEntity(visitTO.getPatient());
    visitEntity.setDoctorEntity(visitTO.getDoctor());
    visitEntity.setMedicalTreatmentEntityList(visitTO.getMedicalTreatments());
    return visitEntity;
  }

}
