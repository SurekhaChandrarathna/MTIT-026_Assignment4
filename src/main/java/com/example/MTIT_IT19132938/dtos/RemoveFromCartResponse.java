package com.example.MTIT_IT19132938.dtos;

public class RemoveFromCartResponse {
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
        return "RemoveFromCart{" +
                "statusMsg='" + message + '\'' +
                '}';
    }
}
