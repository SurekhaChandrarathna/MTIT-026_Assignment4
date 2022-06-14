package com.example.MTIT_IT19166520.controller;

import com.example.MTIT_IT19166520.dtos.AddPaymentDRequest;
import com.example.MTIT_IT19166520.dtos.AddPaymentDResponse;
import com.example.MTIT_IT19166520.model.paymentDetails;
import com.example.MTIT_IT19166520.repository.paymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paymentDetailsService")//Defining the request mapping path
public class AddPaymentDetailsController {

    @Autowired
    private paymentDetailsRepository paymentRepo;

    //Add book items to the cart
    @PostMapping(path = "/addDetails" ,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    AddPaymentDResponse addUser(@RequestBody AddPaymentDRequest paymentDRequest){
        System.out.println(paymentDRequest);

        var addPaymentDRes = new AddPaymentDResponse();

        paymentDetails details =new paymentDetails(); //Creating a new object of user class
        //Add details to the user

        details.setUserId(paymentDRequest.getUserId());
        details.setAccountNumber(paymentDRequest.getAccountNumber());
        details.setAccountType(paymentDRequest.getAccountType());
        details.setPhone(paymentDRequest.getPhone());


        try{
            paymentRepo.save(details);

            addPaymentDRes.setStatusMsg("Payment Detail are added Successfully");
            addPaymentDRes.setUserId(paymentDRequest.getUserId());
            addPaymentDRes.setAccountNumber(paymentDRequest.getAccountNumber());
            addPaymentDRes.setAccountType(paymentDRequest.getAccountType());
            addPaymentDRes.setPhone(paymentDRequest.getPhone());

        }
        catch(Exception ex){

            //Display an error message
            addPaymentDRes.setStatusMsg("Problem while adding the user !!");
        }

        return addPaymentDRes;
    }

}
