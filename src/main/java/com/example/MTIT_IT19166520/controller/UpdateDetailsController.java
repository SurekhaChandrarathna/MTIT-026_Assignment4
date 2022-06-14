package com.example.MTIT_IT19166520.controller;

import com.example.MTIT_IT19166520.dtos.UpdateDetailsRequest;
import com.example.MTIT_IT19166520.dtos.UpdateDetailsResponse;
import com.example.MTIT_IT19166520.exception.ResourceNotFoundException;
import com.example.MTIT_IT19166520.model.paymentDetails;
import com.example.MTIT_IT19166520.repository.paymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/detailsUpdateService")
public class UpdateDetailsController {

    @Autowired
    private paymentDetailsRepository userRepository;

    @PutMapping(path = "/updateDetails/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    UpdateDetailsResponse updateDetails(@PathVariable int id, @RequestBody UpdateDetailsRequest updateDetailsRequest) {
        paymentDetails details = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details does not exist with id: " + id));

        var updateDetailsRes = new UpdateDetailsResponse();

        updateDetailsRes.setUserId(updateDetailsRequest.getUserId());
        details.setAccountNumber(updateDetailsRequest.getAccountNumber());
        details.setAccountType(updateDetailsRequest.getAccountType());
        updateDetailsRes.setPhone(updateDetailsRequest.getPhone());


        try {

            userRepository.save(details);
            updateDetailsRes.setStatusMsg("Payment Details were updated successfully");

        } catch (Exception ex) {

            updateDetailsRes.setStatusMsg("Problem adding the book to the cart");
        }
        return updateDetailsRes;
    }

}
