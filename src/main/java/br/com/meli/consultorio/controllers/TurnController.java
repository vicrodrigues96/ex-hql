package br.com.meli.consultorio.controllers;

import br.com.meli.consultorio.entities.Turn;
import br.com.meli.consultorio.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consultorio/turns")
public class TurnController {

    private TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping
    @RequestMapping("/{status}")
    public List<Turn> listTurnsByStatus(@PathVariable String status) {
        return this.turnService.listTurnByStatus(status);
    }
}
