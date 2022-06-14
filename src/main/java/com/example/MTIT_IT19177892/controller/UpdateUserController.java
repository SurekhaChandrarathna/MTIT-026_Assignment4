package com.example.MTIT_IT19177892.controller;

import com.example.MTIT_IT19177892.dtos.UpdateUserRequest;
import com.example.MTIT_IT19177892.dtos.UpdateUserResponse;
import com.example.MTIT_IT19177892.exception.ResourceNotFoundException;
import com.example.MTIT_IT19177892.model.user;
import com.example.MTIT_IT19177892.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userUpdateService")
public class UpdateUserController {
    @Autowired
    private userRepository userRepository;

    @PutMapping(path = "/updateUser/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    UpdateUserResponse updateUser(@PathVariable int id, @RequestBody UpdateUserRequest updateUserRequest) {
        user updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        var updateUseRes = new UpdateUserResponse();

        updateUseRes.setUserId(updateUserRequest.getUserId());
        updateUser.setUserName(updateUserRequest.getUserName());
        updateUser.setEmail(updateUserRequest.getEmail());
        updateUser.setUserType(updateUserRequest.getUserType());

        try {

            userRepository.save(updateUser);
            updateUseRes.setStatusMsg("User Details were updated successfully");

        } catch (Exception ex) {

            updateUseRes.setStatusMsg("Problem adding the book to the cart");
        }
        return updateUseRes;
    }
}
