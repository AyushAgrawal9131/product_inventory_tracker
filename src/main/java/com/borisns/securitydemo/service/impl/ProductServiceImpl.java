package com.borisns.securitydemo.service.impl;

import com.borisns.securitydemo.model.Product;
import com.borisns.securitydemo.repository.ProductRepository;
import com.borisns.securitydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productrepository;
    public List<Product> getAllProducts() {
        List<Product> list=(List<Product>)this.productrepository.findAll();
        return list;
    }

    public Product getProductById(int id) {
        Product product = null;
        try {
            product=this.productrepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product addProduct(Product p) {
        Product result=productrepository.save(p);
        return result;
    }
    public void deleteProduct(int pid) {

        productrepository.deleteById(pid);
    }
    public void updateProduct(Product product, int productId) {

        productrepository.save(product);
    }

}
