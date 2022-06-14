package com.example.MTIT_026.UserService_IT19177892.controller;

import com.example.MTIT_026.UserService_IT19177892.model.user;
import com.example.MTIT_026.UserService_IT19177892.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ViewUsersService")
public class ViewUsersController {

    @Autowired
    private userRepository userRepository;

    @GetMapping //View the items in the cart
    public List<user> getAllCartItems(){
        return (List<user>) userRepository.findAll();
    }

}
