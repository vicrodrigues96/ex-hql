package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.TurnStatus;

import javax.persistence.EntityManager;

public class TurnStatusDao {

    private EntityManager entityManager;

    public TurnStatusDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(TurnStatus turnStatus) {
        this.entityManager.persist(turnStatus);
    }
}
