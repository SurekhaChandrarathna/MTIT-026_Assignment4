package com.example.MTIT_IT19177892.controller;

import com.example.MTIT_IT19177892.dtos.DeleteUserResponse;
import com.example.MTIT_IT19177892.exception.ResourceNotFoundException;
import com.example.MTIT_IT19177892.model.user;
import com.example.MTIT_IT19177892.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/userDeleteService")
public class DeleteUserController {
    @Autowired
    private userRepository userRepository; //create a object from the Repository class

    //Delete the user
    @DeleteMapping("/delete/{id}")
    public DeleteUserResponse deleteUser(@PathVariable int id, DeleteUserResponse deleteUserResponse){
        //Find the specific item to delete
        user user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        //creating a variable from response class
        var deleteUser = new DeleteUserResponse();

        try{
            userRepository.delete(user);
            deleteUser.setMessage("User was deleted successfully.."); //Displaying the successfully removed message
        }
        catch (Exception ex) {
            //Error message
            System.out.println("Error while deleting");
        }
        return deleteUser;
    }

}
