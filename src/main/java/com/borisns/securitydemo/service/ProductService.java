package com.borisns.securitydemo.service;

import com.borisns.securitydemo.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public Product addProduct(Product p) ;


    public void deleteProduct(int pid) ;

    public void updateProduct(Product product, int productId) ;

}
