package com.example.MTIT_026.CartService_IT19132938.model;

//Importing the packages
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
//create table
@Table(name= "cart")
public class cart {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int cart_id;

    @Column(name = "bookId")
    private String bookId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "quantity")
    private int quantity;
}
