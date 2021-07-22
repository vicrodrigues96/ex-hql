package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Patient;

import javax.persistence.EntityManager;

public class PatientDao {

    private EntityManager entityManager;

    public PatientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Patient patient) {
        this.entityManager.persist(patient);
    }
}
