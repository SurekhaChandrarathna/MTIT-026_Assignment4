package com.example.MTIT_IT19132938.repository;

import com.example.MTIT_IT19132938.model.cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartRepository extends CrudRepository<cart, Integer> {


}
