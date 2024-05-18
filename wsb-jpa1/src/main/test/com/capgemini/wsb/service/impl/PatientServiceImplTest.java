package com.capgemini.wsb.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceImplTest {

  @Mock
  private PatientDao patientDao;
  @Mock
  private VisitDao visitDao;

  @InjectMocks
  private PatientServiceImpl patientServiceImpl;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    patientServiceImpl = new PatientServiceImpl(patientDao, visitDao);
  }


  @Test
  @Transactional
  public void testDeletePatient() {
    // given
    PatientEntity patientEntity = createPatientEntity();

    // when
    patientServiceImpl.deletePatient(patientEntity.getId());

    // then
    verify(patientDao).delete(patientEntity.getId());
  }

  @Test
  @Transactional
  public void findPatientById() {
    // given
    PatientEntity patientEntity = createPatientEntity();
    when(patientDao.findOne(patientEntity.getId())).thenReturn(patientEntity);

    // when
    PatientTO byId = patientServiceImpl.findById(patientEntity.getId());

    // then
    assertThat(byId).isNotNull();
    assertThat(byId.getFirstName()).isEqualTo("Tomasz");
    assertThat(byId.getLastName()).isEqualTo("Nowak");
  }

  private PatientEntity createPatientEntity() {
    PatientEntity patientEntity = new PatientEntity();
    patientEntity.setId(1L);
    patientEntity.setFirstName("Tomasz");
    patientEntity.setLastName("Nowak");
    patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
    patientEntity.setPatientNumber("1564789");
    patientEntity.setEmail("xyz@example.com");
    patientEntity.setAddressEntity(List.of(new AddressEntity()));
    patientEntity.setAge(5);
    patientEntity.setVisitEntity(List.of(new VisitEntity()));
    return patientEntity;
  }

}