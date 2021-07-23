package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.DiaryDao;
import br.com.meli.consultorio.entities.Diary;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    private DiaryDao diaryDao;

    public DiaryService() {
        this.diaryDao = new DiaryDao();
    }

    public void salvar(Diary diary) {
        diaryDao.cadastra(diary);
    }

    public Diary create(Diary diary) {
        return this.diaryDao.create(diary);
    }
}
