package com.example.MTIT_IT19210384.dtos;

public class AddBookResponse {
    private String bookId;
    private String bookName;
    private String authorName;
    private String categoryName;
    private float price;
    private String status_message;

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    @Override
    public String toString(){
        return "AddBookRequest{"+"status_message='" +status_message+ '\''+
                ",bookId='" +bookId+ '\'' +
                ",bookName='"+bookName + '\'' +
                ",authorName='" +authorName +'\'' +
                ",categoryName='" +categoryName +'\'' +
                ",price='" +price+ '\''+
                +'}';
    }
}
