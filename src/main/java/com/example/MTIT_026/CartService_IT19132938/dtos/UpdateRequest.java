package com.example.MTIT_026.CartService_IT19132938.dtos;

public class UpdateRequest {

    private String bookId;

    public String getbookId() {
        return bookId;
    }

    public void setbookId(String bookId) {
        this.bookId = bookId;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UpdateCartRequest{" +
                "quantity='" + quantity +
                '}';
    }

}
