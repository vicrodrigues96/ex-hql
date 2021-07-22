package br.com.meli.consultorio;

import br.com.meli.consultorio.entities.*;
import br.com.meli.consultorio.service.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


//@SpringBootApplication
public class ConsultorioApplication {

    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(ConsultorioApplication.class, args);

        Dentist dentist = new Dentist(
                "Victor",
                "Rodrigues",
                "Av Meli",
                "3039319313",
                LocalDate.of(1996, Month.JULY, 04),
                "9819353213",
                "victor@mercadolivre.com",
                "199"
        );

        Diary diaryJuly22 = new Diary(
                LocalDate.of(2021, Month.JULY, 22),
                LocalDate.of(2021, Month.JULY, 22),
                dentist
        );

        Patient patient = new Patient(
                "Patient 1",
                "Last Name",
                "Av Meli",
                "3039319313",
                LocalDate.of(1996, Month.JULY, 04),
                "9819353213",
                "victor@mercadolivre.com"
        );

        TurnStatus turnStatus = new TurnStatus(
                "Atendimento",
                "Teste"
        );

        Turn turn1 = new Turn(
                LocalDate.of(2021, Month.JULY, 22),
                diaryJuly22,
                patient,
                turnStatus
        );

        Turn turn2 = new Turn(
                LocalDate.of(2021, Month.JULY, 22),
                diaryJuly22,
                patient,
                turnStatus
        );

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        EntityManager entityManager = factory.createEntityManager();

        DentistService dentistService = new DentistService(entityManager);
        DiaryService diaryService = new DiaryService(entityManager);
        PatientService patientService = new PatientService(entityManager);
        TurnStatusService turnStatusService = new TurnStatusService(entityManager);
        TurnService turnService = new TurnService(entityManager);

        entityManager.getTransaction().begin();

        dentistService.salvar(dentist);
        diaryService.salvar(diaryJuly22);
        patientService.salvar(patient);
        turnStatusService.salvar(turnStatus);
        turnService.salvar(turn1);
        turnService.salvar(turn2);

        entityManager.getTransaction().commit();
        ////////////////Consultas

        //Ex1
        TypedQuery<Patient> qryPatient = entityManager.createQuery("select p from Turn t " +
                        "left join Patient as p on p.idPatient = t.patient.idPatient where t.day = :pDate",
                Patient.class);

        qryPatient.setParameter("pDate", LocalDate.of(2021, Month.JULY, 22));

        List<Patient> patients = qryPatient.getResultList();

        patients.forEach(System.out::println);

        //Ex 2
        TypedQuery<Dentist> qryDentist = entityManager.createQuery("select de from Dentist de " +
                        "left join Diary as d on de.id = d.dentist.id " +
                        "left join Turn as t on d.id = t.diary.id " +
                        "where t.day = :pDate " +
                        "group by de " +
                        "having count(*) > 2",
                Dentist.class);

        qryDentist.setParameter("pDate", LocalDate.of(2021, Month.JULY, 22));

        List<Dentist> dentists = qryDentist.getResultList();

        dentists.forEach(System.out::println);
    }
}
