package br.com.meli.consultorio.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus String;
}
