package com.example.MTIT_026.UserService_IT19177892.dtos;

public class DeleteUserResponse {
    private String message;

    //Getters and Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RemoveUser{" +
                "statusMsg='" + message + '\'' +
                '}';
    }
}
