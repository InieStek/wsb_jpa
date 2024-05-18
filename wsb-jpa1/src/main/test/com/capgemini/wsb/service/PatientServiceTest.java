package com.capgemini.wsb.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.capgemini.wsb.dto.VisitTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

  @Autowired
  private PatientService patientService;

  @Test
  @Transactional
  void findVisitByPatientId() {
    //given
    //when
    List<VisitTO> visitByPatientId = patientService.findVisitByPatientId(1L);
    //then
    assertThat(visitByPatientId).isNotNull();
    assertThat(visitByPatientId.size()).isEqualTo(3);
  }
}