package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.DiaryDao;
import br.com.meli.consultorio.daos.TurnDao;
import br.com.meli.consultorio.entities.Diary;
import br.com.meli.consultorio.entities.Turn;

import javax.persistence.EntityManager;

public class TurnService {

    private EntityManager entityManager;
    private TurnDao turnDao;

    public TurnService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.turnDao = new TurnDao(entityManager);
    }

    public void salvar(Turn turn) {
        turnDao.cadastra(turn);
    }
}
