package br.com.meli.consultorio.controllers;

import br.com.meli.consultorio.entities.TurnStatus;
import br.com.meli.consultorio.service.TurnStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultorio/turnstatus")
public class TurnStatusController {

    private TurnStatusService turnStatusService;

    @Autowired
    public TurnStatusController(TurnStatusService turnStatusService) {
        this.turnStatusService = turnStatusService;
    }

    @PostMapping
    public TurnStatus create(@RequestBody TurnStatus turnStatus) {
        return this.turnStatusService.create(turnStatus);
    }
}
