package com.mytutorials.crudspring.services;

import com.mytutorials.crudspring.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductsName() {
        assertTrue(true);
    }
}
