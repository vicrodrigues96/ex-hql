package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Dentist;

import javax.persistence.EntityManager;

public class DentistDao {

    private EntityManager entityManager;

    public DentistDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Dentist dentist) {
        this.entityManager.persist(dentist);
    }
}
