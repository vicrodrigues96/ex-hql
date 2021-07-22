package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.DentistDao;
import br.com.meli.consultorio.entities.Dentist;

import javax.persistence.EntityManager;

public class DentistService {

    private EntityManager entityManager;
    private DentistDao dentistDao;

    public DentistService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.dentistDao = new DentistDao(entityManager);
    }

    public void salvar(Dentist dentist) {
        dentistDao.cadastra(dentist);
    }
}
