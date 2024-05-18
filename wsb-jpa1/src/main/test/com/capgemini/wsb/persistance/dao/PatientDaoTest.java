package com.capgemini.wsb.persistance.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientDaoTest {

  @Autowired
  private PatientDao patientDao;

  @Transactional
  @Test
  public void testShouldFindPatientByLastName() {
    // given
    // when
    List<PatientEntity> patientEntity = patientDao.findPatientByLastName("Davis");
    // then
    assertThat(patientEntity).isNotEmpty();
    assertThat(patientEntity.size()).isEqualTo(3);
    assertThat(patientEntity.get(0).getLastName()).isEqualTo("Davis");
  }

  @Transactional
  @Test
  public void testShouldFindPatientByMoreThanOneVisit(){
    //given
    //when
    List<PatientEntity> patientWithMoreThanXVisits = patientDao.findPatientWithMoreThanXVisits(2);
    //then
    assertThat(patientWithMoreThanXVisits).isNotEmpty();
    assertThat(patientWithMoreThanXVisits.size()).isEqualTo(1);
  }

  @Transactional
  @Test
  public void testShouldFindPatientWithMoreThan40YearsOld(){
    //given
    //when
    List<PatientEntity> patientsMoreThanXAge = patientDao.findPatientsMoreThanXAge(40);
    //then
    assertThat(patientsMoreThanXAge).isNotEmpty();
    assertThat(patientsMoreThanXAge.size()).isEqualTo(3);
  }
}