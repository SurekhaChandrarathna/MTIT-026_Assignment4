package com.example.MTIT_IT19210384.dtos;

import javax.persistence.Column;

public class AddBookRequest {

    private String bookId;
    private String bookName;
    private String authorName;
    private String categoryName;
    private float price;

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

    @Override
    public String toString(){
        return "AddBookRequest{"+"bookId='" +bookId+ '\'' +
                ",bookName='"+bookName + '\'' +
                ",authorName='" +authorName +'\'' +
                ",categoryName='" +categoryName +'\'' +
                ",price='" +price+ '\''+'}';
    }
}
