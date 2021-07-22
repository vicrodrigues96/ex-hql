package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.PatientDao;
import br.com.meli.consultorio.entities.Patient;

import javax.persistence.EntityManager;

public class PatientService {

    private EntityManager entityManager;
    private PatientDao patientDao;

    public PatientService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.patientDao = new PatientDao(entityManager);
    }

    public void salvar(Patient patient) {
        patientDao.cadastra(patient);
    }
}
