package com.example.MTIT_IT19210384.controller;

import com.example.MTIT_IT19210384.model.book;
import com.example.MTIT_IT19210384.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ViewBooksService")
public class ViewBooksController {

    @Autowired
    private bookRepository userRepository;

    @GetMapping //View the items in the cart
    public List<book> getAllCartItems(){
        return (List<book>) userRepository.findAll();
    }

}
