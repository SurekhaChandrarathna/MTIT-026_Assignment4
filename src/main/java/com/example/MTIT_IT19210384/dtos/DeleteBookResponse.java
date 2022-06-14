package com.example.MTIT_IT19210384.dtos;

public class DeleteBookResponse {
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
        return "RemoveBook{" +
                "statusMsg='" + message + '\'' +
                '}';
    }
}
