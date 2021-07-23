package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Turn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TurnDao {

    private EntityManager entityManager;

    public TurnDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        this.entityManager = factory.createEntityManager();
    }

    public void cadastra(Turn turn) {
        this.entityManager.persist(turn);
    }

    public List<Turn> listTurnByStatus(String status) {
        TypedQuery<Turn> qryTurn = entityManager.createQuery("" +
                "select t from Turn t " +
                "left join TurnStatus  as ts on t.turnStatus.id = ts.id " +
                "where ts.name = lower(:pName) ", Turn.class);

        qryTurn.setParameter("pName", status.toLowerCase());

        return qryTurn.getResultList();
    }
}
