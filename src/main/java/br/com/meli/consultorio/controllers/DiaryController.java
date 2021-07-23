package br.com.meli.consultorio.controllers;

import br.com.meli.consultorio.entities.Diary;
import br.com.meli.consultorio.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultorio/diaries")
public class DiaryController {

    private DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping
    public Diary create(@RequestBody Diary diary) {
        return this.diaryService.create(diary);
    }
}
