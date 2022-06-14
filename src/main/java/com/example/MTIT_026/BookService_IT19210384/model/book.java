package com.example.MTIT_026.BookService_IT19210384.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookId")
    private String bookId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "authorName")
    private String authorName;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "price")
    private float price;

}
