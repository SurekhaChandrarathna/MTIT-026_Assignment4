package com.example.MTIT_IT19166520.controller;

import com.example.MTIT_IT19166520.model.paymentDetails;
import com.example.MTIT_IT19166520.repository.paymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ViewDetailsService")
public class ViewAllDetailsController {

    @Autowired
    private paymentDetailsRepository detailsRepository;

    @GetMapping //View the items in the cart
    public List<paymentDetails> getAllCartItems(){
        return (List<paymentDetails>) detailsRepository.findAll();
    }

}
