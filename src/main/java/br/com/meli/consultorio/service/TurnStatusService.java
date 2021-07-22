package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.TurnDao;
import br.com.meli.consultorio.daos.TurnStatusDao;
import br.com.meli.consultorio.entities.Turn;
import br.com.meli.consultorio.entities.TurnStatus;

import javax.persistence.EntityManager;

public class TurnStatusService {

    private EntityManager entityManager;
    private TurnStatusDao turnStatusDao;

    public TurnStatusService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.turnStatusDao = new TurnStatusDao(entityManager);
    }

    public void salvar(TurnStatus turnStatus) {
        turnStatusDao.cadastra(turnStatus);
    }
}
