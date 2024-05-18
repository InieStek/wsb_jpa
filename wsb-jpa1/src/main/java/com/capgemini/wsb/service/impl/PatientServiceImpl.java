package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

  private final PatientDao patientDao;
  private final VisitDao visitDao;

  @Autowired
  public PatientServiceImpl(PatientDao pPatientDao, VisitDao pVisitDao) {
    patientDao = pPatientDao;
    visitDao = pVisitDao;
  }

  @Override
  public PatientTO findById(Long id) {
    final PatientEntity entity = patientDao.findOne(id);
    return PatientMapper.mapToTO(entity);
  }

  @Override
  public List<VisitTO> findAllVisit(Long id) {
    return visitDao.findAllByPatientId(id);
  }

  @Transactional
  @Override
  public void deletePatient(Long patientId) {
    patientDao.delete(patientId);
  }

  @Override
  public List<PatientTO> findPatientByLastName(String lastName) {
    List<PatientEntity> patients = patientDao.findPatientByLastName(lastName);
    return patients.stream().map(PatientMapper::mapToTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<PatientTO> findPatientWithMoreThanXVisits(int x) {
    List<PatientEntity> patientWithMoreThanXVisits = patientDao.findPatientWithMoreThanXVisits(x);
    return patientWithMoreThanXVisits.stream().map(PatientMapper::mapToTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<PatientTO> findPatientWithMoreThanXAge(int age) {
    List<PatientEntity> patientWithMoreThanXVisits = patientDao.findPatientWithMoreThanXVisits(age);
    return patientWithMoreThanXVisits.stream().map(PatientMapper::mapToTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<VisitTO> findVisitByPatientId(Long patientId) {
    List<VisitEntity> visitsById = patientDao.findVisitsById(patientId);
    return visitsById.stream().map(VisitMapper::mapToTO)
        .collect(Collectors.toList());
  }
}
