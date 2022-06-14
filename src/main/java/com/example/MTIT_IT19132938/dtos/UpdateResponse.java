package com.example.MTIT_IT19132938.dtos;

public class UpdateResponse {

    private String statusMsg;
    private String bookId;
    private int quantity;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UpdateResponse{" +
                "statusMsg='" + statusMsg + '\'' +
                ", quantity='" + quantity + '\'' +
                ", bookId='" + bookId + '\''+
                '}';
    }

}
