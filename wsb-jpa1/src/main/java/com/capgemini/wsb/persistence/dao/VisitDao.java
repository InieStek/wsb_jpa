package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;


public interface VisitDao extends Dao<VisitEntity, Long> {
  List<VisitTO> findAllByPatientId(Long patientId);
}
