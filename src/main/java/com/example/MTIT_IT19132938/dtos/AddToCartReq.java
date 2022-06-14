package com.example.MTIT_IT19132938.dtos;

public class AddToCartReq {

    private String bookId;
    private String userId;
    private int quantity;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddToCartReq{" +
                "bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

}
