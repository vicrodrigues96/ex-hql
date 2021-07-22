package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Diary;
import br.com.meli.consultorio.entities.Turn;

import javax.persistence.EntityManager;

public class TurnDao {

    private EntityManager entityManager;

    public TurnDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Turn turn) {
        this.entityManager.persist(turn);
    }
}
