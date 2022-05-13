package com.example.Project1.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private String role;

    @Column(name = "email", nullable = false)
    private String email;
}
