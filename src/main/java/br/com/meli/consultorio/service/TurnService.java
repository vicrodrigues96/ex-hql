package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.TurnDao;
import br.com.meli.consultorio.entities.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {

    private TurnDao turnDao;

    @Autowired
    public TurnService() {
        this.turnDao = new TurnDao();
    }

    public Turn create(Turn turn) {
        return turnDao.create(turn);
    }

    public List<Turn> listTurnByStatus(String status) {
        return this.turnDao.listTurnByStatus(status);
    }
}
