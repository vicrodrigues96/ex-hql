package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Diary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DiaryDao {

    private EntityManager entityManager;

    public DiaryDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        this.entityManager = factory.createEntityManager();
    }

    public void cadastra(Diary diary) {
        this.entityManager.persist(diary);
    }


    public Diary create(Diary diary) {
        entityManager.getTransaction().begin();
        //this.entityManager.persist(diary.getDentist());

        this.entityManager.persist(diary);
        entityManager.getTransaction().commit();

        return diary;
    }
}
