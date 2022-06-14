package com.example.MTIT_026.CartService_IT19132938.controller;

//Importing the packages
import com.example.MTIT_026.CartService_IT19132938.model.cart;
import com.example.MTIT_026.CartService_IT19132938.repository.cartRepository;
import com.example.MTIT_026.CartService_IT19132938.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ViewCartService")
public class ViewCartController {

    @Autowired
    private cartRepository cartRepository;

    @GetMapping //View the items in the cart
    public List<cart> getAllCartItems(){
        return (List<cart>) cartRepository.findAll();
    }

}
