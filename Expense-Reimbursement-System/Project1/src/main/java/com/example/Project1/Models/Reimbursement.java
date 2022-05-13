package com.example.Project1.Models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Reimbursements")
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {

    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="date")
    private String date;

    @Column(name="amount")
    private double amount;

    @Column(name="status")
    private String status;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

}
