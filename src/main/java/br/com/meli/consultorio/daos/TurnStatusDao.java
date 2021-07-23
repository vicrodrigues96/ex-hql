package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.TurnStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TurnStatusDao {

    private EntityManager entityManager;

    public TurnStatusDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        this.entityManager = factory.createEntityManager();
    }

    public TurnStatus create(TurnStatus turnStatus) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(turnStatus);
        entityManager.getTransaction().commit();
        return turnStatus;
    }
}
