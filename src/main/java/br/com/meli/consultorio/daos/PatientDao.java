package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PatientDao {

    private EntityManager entityManager;

    public PatientDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        this.entityManager = factory.createEntityManager();
    }

    public List<Patient> listAllPatientsByDay(String date) {
        TypedQuery<Patient> qryPatient = entityManager.createQuery("select p from Patient p " +
                        "left join Turn as t on p.id = t.patient.idPatient where t.day = :pDate " +
                        "group by p",
                Patient.class);

        qryPatient.setParameter("pDate", LocalDate.parse(date));

        List<Patient> patients = qryPatient.getResultList();

        return patients;
    }

    public Patient create(Patient patient) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(patient);
        entityManager.getTransaction().commit();

        return patient;
    }
}
