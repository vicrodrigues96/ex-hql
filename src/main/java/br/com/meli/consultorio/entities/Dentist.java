package br.com.meli.consultorio.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dentist")
@NoArgsConstructor
@Data
public class Dentist {

    public Dentist(String name,
                   String lastName,
                   String adress,
                   String dni,
                   LocalDate birthDate,
                   String phone,
                   String email,
                   String codeMap) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.codeMap = codeMap;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String adress;

    private String dni;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String phone;

    private String email;

    @Column(name = "code_map")
    private String codeMap;

//    @OneToMany(mappedBy = "dentist")
//    @JsonManagedReference(value = "dentist-diary")
//    private List<Diary> diaries;

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
