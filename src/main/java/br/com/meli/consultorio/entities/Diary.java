package br.com.meli.consultorio.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diaries")
@NoArgsConstructor
@Data
public class Diary {

    public Diary(LocalDate startTime, LocalDate endingTime) {
        this.startTime = startTime;
        this.endingTime = endingTime;
//        this.dentist = dentist;
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
//    @JsonBackReference(value = "dentist-diary")
    private Dentist dentist;

    public void setDentist(Long id) {
        this.dentist = new Dentist();
        this.dentist.setId(id);
    }

    public Long getDentist() {
        return dentist.getId();
    }

    //    @OneToMany(mappedBy = "diary")
//    @JsonManagedReference(value = "turn-diary")
//    private List<Turn> turn;

}
