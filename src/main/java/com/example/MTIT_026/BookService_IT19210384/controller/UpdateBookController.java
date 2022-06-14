package com.example.MTIT_026.BookService_IT19210384.controller;

import com.example.MTIT_026.BookService_IT19210384.dtos.UpdateBookRequest;
import com.example.MTIT_026.BookService_IT19210384.dtos.UpdateBookResponse;
import com.example.MTIT_026.BookService_IT19210384.model.book;
import com.example.MTIT_026.BookService_IT19210384.repository.bookRepository;
import com.example.MTIT_026.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bookUpdateService")
public class UpdateBookController {

    @Autowired
    private bookRepository bookRepository;

    @PutMapping(path = "/updateBook/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    UpdateBookResponse updateBook(@PathVariable int id, @RequestBody UpdateBookRequest updateBookRequest) {
        book updateBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book item not exist with id: " + id));

        var updateRes = new UpdateBookResponse();

        updateRes.setBookId(updateBookRequest.getBookId());
        updateBook.setBookName(updateBookRequest.getBookName());
        updateBook.setAuthorName(updateBookRequest.getAuthorName());
        updateBook.setCategoryName(updateBookRequest.getCategoryName());
        updateBook.setPrice(updateBookRequest.getPrice());

        try {

            bookRepository.save(updateBook);
            updateRes.setStatusMsg("Updated successfully");

        } catch (Exception ex) {

            updateRes.setStatusMsg("Problem adding the book to the cart");
        }
        return updateRes;
    }

}
