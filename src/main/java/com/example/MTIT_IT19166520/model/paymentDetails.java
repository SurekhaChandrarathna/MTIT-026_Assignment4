package com.example.MTIT_IT19166520.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
//create table
@Table(name= "paymentDetails")
public class paymentDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "accountType")
    private String accountType;

    @Column(name = "phone")
    private String phone;


}
