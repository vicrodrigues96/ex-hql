package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Diary;

import javax.persistence.EntityManager;

public class DiaryDao {

    private EntityManager entityManager;

    public DiaryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastra(Diary diary) {
        this.entityManager.persist(diary);
    }
}
