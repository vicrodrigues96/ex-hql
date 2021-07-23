package br.com.meli.consultorio.service;

import br.com.meli.consultorio.daos.PatientDao;
import br.com.meli.consultorio.entities.Dentist;
import br.com.meli.consultorio.entities.Patient;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PatientService {

    private PatientDao patientDao;

    public PatientService() {
        this.patientDao = new PatientDao();
    }

    public List<Patient> listAllPatientsByDay(String date) {
        return this.patientDao.listAllPatientsByDay(date);
    }

    public Patient create(Patient patient) {

        return this.patientDao.create(patient);
    }
}
