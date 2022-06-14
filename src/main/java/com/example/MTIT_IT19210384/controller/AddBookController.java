package com.example.MTIT_IT19210384.controller;


import com.example.MTIT_IT19210384.dtos.AddBookRequest;
import com.example.MTIT_IT19210384.dtos.AddBookResponse;
import com.example.MTIT_IT19210384.model.book;
import com.example.MTIT_IT19210384.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/bookService")
public class AddBookController {

    @Autowired
    private bookRepository bookRepository;

    @PostMapping(path = "/addBook" ,consumes = "application/json" , produces = "application/json")
    public @ResponseBody
    AddBookResponse addBook(@RequestBody AddBookRequest addBookRequest)
    {
        System.out.println(addBookRequest);

        var addbookResponse = new AddBookResponse();

        book book = new book();
        book.setBookId(addBookRequest.getBookId());
        book.setBookName(addBookRequest.getBookName());
        book.setAuthorName(addBookRequest.getAuthorName());
        book.setCategoryName(addBookRequest.getCategoryName());
        book.setPrice(addBookRequest.getPrice());

        try{

            bookRepository.save(book);

            addbookResponse.setStatus_message("Book is added successfully");
            addbookResponse.setBookId(addBookRequest.getBookId());
            addbookResponse.setBookName(addBookRequest.getBookName());
            addbookResponse.setAuthorName(addBookRequest.getAuthorName());
            addbookResponse.setCategoryName(addBookRequest.getCategoryName());
            addbookResponse.setPrice(addBookRequest.getPrice());

        }
        catch (Exception e){
            addbookResponse.setStatus_message("Problem Occurred while adding user");
        }

        return addbookResponse;

    }
}
