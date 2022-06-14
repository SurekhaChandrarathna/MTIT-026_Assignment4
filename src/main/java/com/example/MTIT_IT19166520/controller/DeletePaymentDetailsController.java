package com.example.MTIT_IT19166520.controller;

import com.example.MTIT_IT19166520.dtos.DeletePaymentDResponse;
import com.example.MTIT_IT19166520.exception.ResourceNotFoundException;
import com.example.MTIT_IT19166520.model.paymentDetails;
import com.example.MTIT_IT19166520.repository.paymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/detailsDeleteService")
public class DeletePaymentDetailsController {

    @Autowired
    private paymentDetailsRepository paymentRepo; //create a object from the Repository class

    //Delete the user
    @DeleteMapping("/delete/{id}")
    public DeletePaymentDResponse deleteDetails(@PathVariable int id, DeletePaymentDResponse deleteUserResponse){
        //Find the specific item to delete
        paymentDetails details = paymentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id: " + id));

        //creating a variable from response class
        var deleteDetails = new DeletePaymentDResponse();

        try{
            paymentRepo.delete(details);
            deleteDetails.setMessage("Payment details was deleted successfully.."); //Displaying the successfully removed message
        }
        catch (Exception ex) {
            //Error message
            System.out.println("Error while deleting");
        }
        return deleteDetails;
    }

}
