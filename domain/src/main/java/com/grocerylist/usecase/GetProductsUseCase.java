package com.grocerylist.usecase;

import com.grocerylist.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsUseCase {
    //TODO DELETE, use service in core/services module, there are already repositories set up
    public List<Product> getAllProducts(){
        return null;
        //TODO: to implement
    }
}
