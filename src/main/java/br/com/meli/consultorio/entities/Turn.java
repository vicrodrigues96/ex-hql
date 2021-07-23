package br.com.meli.consultorio.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turns")
@NoArgsConstructor
@Data
public class Turn {

    public Turn(LocalDate day, Diary diary, Patient patient, TurnStatus turnStatus) {
        this.day = day;
        this.diary = diary;
        this.patient = patient;
        this.turnStatus = turnStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long id;

    private LocalDate day;

    @ManyToOne
   // @JsonBackReference(value = "turn-diary")
    @JoinColumn(name = "id_diary")
    private Diary diary;

    @ManyToOne
   // @JsonBackReference(value = "patient-turn")
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne
   // @JsonBackReference(value = "turn-turnStatus")
    @JoinColumn(name = "id_turn_status")
    private TurnStatus turnStatus;

    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", day=" + day +
                ", diary=" + diary +
                ", patient=" + patient +
                ", turnStatus=" + turnStatus +
                '}';
    }
}
