package br.com.meli.consultorio.daos;

import br.com.meli.consultorio.entities.Dentist;
import br.com.meli.consultorio.entities.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class DentistDao {

    private EntityManager entityManager;

    public DentistDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitName");
        this.entityManager = factory.createEntityManager();
    }
    public List<Dentist> listDentistsHasTwoTurnsByDate(String date) {

        TypedQuery<Dentist> qryDentist = entityManager.createQuery("select de from Dentist de " +
                        "left join Diary as d on de.id = d.dentist.id " +
                        "left join Turn as t on d.id = t.diary.id " +
                        "where t.day = :pDate " +
                        "group by de " +
                        "having count(*) > 2",
                Dentist.class);

        qryDentist.setParameter("pDate", LocalDate.parse(date));

        List<Dentist> dentists = qryDentist.getResultList();

        return dentists;
    };

    public List<Diary> listDiariesFromAnDentist(Long id) {

        TypedQuery<Diary> qryDentistDiary = entityManager.createQuery("" +
                "select d from Diary d, Dentist de " +
                "where d.dentist.id = de.id and de.id = :pId ", Diary.class);

        qryDentistDiary.setParameter("pId", id);

        return qryDentistDiary.getResultList();
    }

    public Dentist create(Dentist dentist) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(dentist);
        entityManager.getTransaction().commit();

        return dentist;
    }
}
