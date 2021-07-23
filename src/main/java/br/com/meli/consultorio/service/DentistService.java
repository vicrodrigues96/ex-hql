package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.DentistDao;
import br.com.meli.consultorio.entities.Dentist;
import br.com.meli.consultorio.entities.Diary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    private DentistDao dentistDao;

    public DentistService() {
        this.dentistDao = new DentistDao();
    }

    public void salvar(Dentist dentist) {
        dentistDao.create(dentist);
    }

    public List<Dentist> listDentistsHasTwoTurnsByDate(String date) {
        return this.dentistDao.listDentistsHasTwoTurnsByDate(date);
    };

    public List<Diary> listDiariesFromAnDentist(Long id) {
        return this.dentistDao.listDiariesFromAnDentist(id);
    }

    public Dentist create(Dentist dentist) {
        return this.dentistDao.create(dentist);
    }
}
