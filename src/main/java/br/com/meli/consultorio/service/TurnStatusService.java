package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.TurnStatusDao;
import br.com.meli.consultorio.entities.TurnStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class TurnStatusService {

    private TurnStatusDao turnStatusDao;

    public TurnStatusService() {
        this.turnStatusDao = new TurnStatusDao();
    }

    public TurnStatus create(TurnStatus turnStatus) {
        return turnStatusDao.create(turnStatus);
    }
}
