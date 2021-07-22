package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.DiaryDao;
import br.com.meli.consultorio.entities.Diary;

import javax.persistence.EntityManager;

public class DiaryService {

    private EntityManager entityManager;
    private DiaryDao diaryDao;

    public DiaryService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.diaryDao = new DiaryDao(entityManager);
    }

    public void salvar(Diary diary) {
        diaryDao.cadastra(diary);
    }
}
