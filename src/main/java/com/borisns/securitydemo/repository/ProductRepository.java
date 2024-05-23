package com.borisns.securitydemo.repository;

import com.borisns.securitydemo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
     Product findById(int id);
}
