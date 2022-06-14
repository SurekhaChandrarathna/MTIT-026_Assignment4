package com.example.MTIT_IT19132938.controller;

//importing the packages
import com.example.MTIT_IT19132938.dtos.RemoveFromCartResponse;
import com.example.MTIT_IT19132938.exception.ResourceNotFoundException;
import com.example.MTIT_IT19132938.model.cart;
import com.example.MTIT_IT19132938.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cartDeleteService") //defining the path
public class DeleteCartItemController {

    @Autowired
    private cartRepository cartRepository; //create a object from the Repository class

    //Delete the cart item
    @DeleteMapping("/delete/{id}")
    public RemoveFromCartResponse deleteEmployee(@PathVariable int id , RemoveFromCartResponse removeFromCartResponse){
       //Find the specific item to delete
        cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not exist with id: " + id));

        //creating a variable from response class
        var deleteRes = new RemoveFromCartResponse();

        try{
            cartRepository.delete(cart);
            deleteRes.setMessage("Cart item "+ id +" was removed from the cart successfully.."); //Displaying the successfully removed message
        }
        catch (Exception ex) {
            //Error message
            System.out.println("Error while deleting");
        }
        return deleteRes;
    }
}
