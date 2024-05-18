package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import java.util.List;

public interface PatientService {

  public PatientTO findById(final Long id);

  public List<VisitTO> findAllVisit(final Long id);

  public void deletePatient(Long patientId);

  public List<PatientTO> findPatientByLastName(final String lastName);

  public List<PatientTO> findPatientWithMoreThanXVisits(final int x);

  public List<PatientTO> findPatientWithMoreThanXAge(final int age);

  public List<VisitTO> findVisitByPatientId(final Long patientId);

}
