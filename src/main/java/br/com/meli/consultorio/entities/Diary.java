package br.com.meli.consultorio.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "diaries")
@NoArgsConstructor
@Data
public class Diary {

    public Diary(LocalDate startTime, LocalDate endingTime, Dentist dentist) {
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private Long id;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "ending_time")
    private LocalDate endingTime;

    @ManyToOne
    @JoinColumn(name = "id_dentist")
    private Dentist dentist;

    @OneToMany(mappedBy = "diary")
    private List<Turn> turn;

}
