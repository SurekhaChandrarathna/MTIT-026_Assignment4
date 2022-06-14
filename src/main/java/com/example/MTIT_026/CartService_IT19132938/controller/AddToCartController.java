package com.example.MTIT_026.CartService_IT19132938.controller;


import com.example.MTIT_026.CartService_IT19132938.dtos.AddToCartReq;
import com.example.MTIT_026.CartService_IT19132938.dtos.AddToCartRes;
import com.example.MTIT_026.CartService_IT19132938.model.cart;
import com.example.MTIT_026.CartService_IT19132938.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cartService")//Defining the request mapping path
public class AddToCartController {

    @Autowired
    private cartRepository cartRepo;

    //Add book items to the cart
    @PostMapping(path = "/addToCart" ,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    AddToCartRes addToCart(@RequestBody AddToCartReq addToCartRequest){
        System.out.println(addToCartRequest);

        var addToCartRes = new AddToCartRes();

        cart cart =new cart(); //Creating a new object of cart class
        //Add details to the cart
        cart.setBookId(addToCartRequest.getBookId());
        cart.setUserId(addToCartRequest.getUserId());
        cart.setQuantity(addToCartRequest.getQuantity());

        try{
            cartRepo.save(cart);

            addToCartRes.setStatusMsg("Book is added to the cart successfully");//Successfully message
            addToCartRes.setBookId(addToCartRequest.getBookId());
            addToCartRes.setUserId(addToCartRequest.getUserId());
            addToCartRes.setQuantity(addToCartRequest.getQuantity());

        }
        catch(Exception ex){

            //Display an error message
            addToCartRes.setStatusMsg("Problem adding the book to te cart");
        }

        return addToCartRes;
    }

}
