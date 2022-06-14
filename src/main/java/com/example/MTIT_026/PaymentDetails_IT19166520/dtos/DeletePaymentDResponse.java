package com.example.MTIT_026.PaymentDetails_IT19166520.dtos;

public class DeletePaymentDResponse {
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
