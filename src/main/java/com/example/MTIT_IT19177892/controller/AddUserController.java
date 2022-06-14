package com.example.MTIT_IT19177892.controller;

import com.example.MTIT_IT19177892.dtos.AddUserRequest;
import com.example.MTIT_IT19177892.dtos.AddUserResponse;
import com.example.MTIT_IT19177892.model.user;
import com.example.MTIT_IT19177892.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userService")//Defining the request mapping path
public class AddUserController {
    @Autowired
    private userRepository userRepo;

    //Add book items to the cart
    @PostMapping(path = "/addUser" ,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    AddUserResponse addUser(@RequestBody AddUserRequest addUserRequest){
        System.out.println(addUserRequest);

        var addUserRes = new AddUserResponse();

        user user =new user(); //Creating a new object of user class
        //Add details to the user

        user.setUserId(addUserRequest.getUserId());
        user.setUserName(addUserRequest.getUserName());
        user.setEmail(addUserRequest.getEmail());
        user.setUserType(addUserRequest.getUserType());

        try{
            userRepo.save(user);

            addUserRes.setStatus_message("User is added successfully");
            addUserRes.setUserId(addUserRequest.getUserId());
            addUserRes.setUserName(addUserRequest.getUserName());
            addUserRes.setEmail(addUserRequest.getEmail());
            addUserRes.setUserType(addUserRequest.getUserType());

        }
        catch(Exception ex){

            //Display an error message
            addUserRes.setStatus_message("Problem while adding the user !!");
        }

        return addUserRes;
    }

}
