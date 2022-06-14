package com.example.MTIT_IT19210384.controller;

import com.example.MTIT_IT19210384.dtos.DeleteBookResponse;
import com.example.MTIT_IT19210384.exception.ResourceNotFoundException;
import com.example.MTIT_IT19210384.model.book;
import com.example.MTIT_IT19210384.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bookDeleteService")
public class DeleteBookController {

    @Autowired
    private bookRepository bookRepository; //create a object from the Repository class

    //Delete the user
    @DeleteMapping("/delete/{id}")
    public DeleteBookResponse deleteEmployee(@PathVariable int id, DeleteBookResponse deleteUserResponse) {
        //Find the specific item to delete
        book user = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id: " + id));

        //creating a variable from response class
        var deleteBook = new DeleteBookResponse();

        try {
            bookRepository.delete(user);
            deleteBook.setMessage("Book was deleted successfully.."); //Displaying the successfully removed message
        } catch (Exception ex) {
            //Error message
            System.out.println("Error while deleting");
        }
        return deleteBook;
    }
}
