package br.com.meli.consultorio.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {

    public Patient(String name,
                    String lastName,
                    String adress,
                    String dni,
                    LocalDate birthDate,
                    String phone,
                    String email) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long idPatient;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String adress;

    private String dni;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Turn> turns;

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
