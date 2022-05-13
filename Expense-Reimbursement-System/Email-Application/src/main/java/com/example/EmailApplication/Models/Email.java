package com.example.EmailApplication.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Emails")
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_sent")
    private String date;

    @Column(name = "receiver")
    private String receiver;
}
