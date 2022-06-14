package com.example.MTIT_IT19132938.controller;

import com.example.MTIT_IT19132938.dtos.UpdateRequest;
import com.example.MTIT_IT19132938.dtos.UpdateResponse;
import com.example.MTIT_IT19132938.exception.ResourceNotFoundException;
import com.example.MTIT_IT19132938.model.cart;
import com.example.MTIT_IT19132938.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cartUpdateService")
public class UpdateCartController {

    @Autowired
    private cartRepository cartRepo;


   /* @PutMapping("/update")
    public cart updateProduct(cart cart) {
        cart existingBook = cartRepo.findById(cart.getCart_id()).orElse(null);

        existingBook.setBookId(cart.getBookId());
        existingBook.setQuantity(cart.getQuantity());
        existingBook.setUserId(cart.getUserId());

        return cartRepo.save(existingBook);
    }

    @PutMapping(path = "/UpdateCart" ,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    UpdateResponse updateCart(@RequestBody UpdateRequest updateRequest){
        var updateRes = new UpdateResponse();


        ResponseEntity<Integer> result = new ResponseEntity<>(cartRepo.updateCart)

        String[] response = result.toString().split(",");


    }*/

    @PutMapping(path = "/UpdateCart/{id}" ,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    UpdateResponse updateCart(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        cart updateCart = cartRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not exist with id: " + id));

        var updateRes = new UpdateResponse();

        updateCart.setQuantity(updateRequest.getQuantity());
        updateRes.setBookId(updateRequest.getbookId());

        try {

            cartRepo.save(updateCart);
            updateRes.setStatusMsg("Updated successfully");

        } catch (Exception ex) {

            updateRes.setStatusMsg("Problem adding the book to the cart");
        }

        return updateRes;
    }
}
