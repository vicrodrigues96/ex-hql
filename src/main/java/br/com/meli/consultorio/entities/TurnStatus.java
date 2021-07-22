package br.com.meli.consultorio.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turn_status")
@NoArgsConstructor
@Data
public class TurnStatus {

    public TurnStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn_status")
    private Long idTurnStatus;

    private String name;

    private String description;
}
