package com.borisns.securitydemo.service.impl;

import com.borisns.securitydemo.model.Product;
import com.borisns.securitydemo.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository mockProductrepository;

    @InjectMocks
    private ProductServiceImpl productServiceImplUnderTest;

    @Test
    public void testGetAllProducts() {
        // Setup
        // Configure ProductRepository.findAll(...).
        final Iterable<Product> products = Arrays.asList(new Product(1, "name", "description of the product", 1, 100));
        when(mockProductrepository.findAll()).thenReturn(products);

        // Run the test
        final List<Product> result = productServiceImplUnderTest.getAllProducts();

        // Verify the results
    }

    @Test
    public void testGetAllProducts_ProductRepositoryReturnsNoItems() {
        // Setup
        when(mockProductrepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Product> result = productServiceImplUnderTest.getAllProducts();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testGetProductById() {
        // Setup
        // Configure ProductRepository.findById(...).
        final Product product = new Product(1, "name", "description of the product", 1, 100);
        when(mockProductrepository.findById(0)).thenReturn(product);

        // Run the test
        final Product result = productServiceImplUnderTest.getProductById(0);

        // Verify the results
    }

    @Test
    public void testAddProduct() {
        // Setup
        final Product p = new Product(1, "name", "description of the product", 1, 100);

        // Configure ProductRepository.save(...).
        final Product product = new Product(1, "name", "description", 0, 0);
        when(mockProductrepository.save(any(Product.class))).thenReturn(product);

        // Run the test
        final Product result = productServiceImplUnderTest.addProduct(p);

        // Verify the results
    }

    @Test
    public void testDeleteProduct() {
        // Setup
        // Run the test
        productServiceImplUnderTest.deleteProduct(0);

        // Verify the results
        verify(mockProductrepository).deleteById(0);
    }

    @Test
    public void testUpdateProduct() {
        // Setup
        final Product product = new Product(0, "name", "description", 0, 0);

        // Run the test
        productServiceImplUnderTest.updateProduct(product, 0);

        // Verify the results
        verify(mockProductrepository).save(any(Product.class));
    }
}
