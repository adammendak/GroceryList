package com.grocerylist.usecase;

import com.grocerylist.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProcessProductUseCase {
    //TODO DELETE, use service in core/services module, there are already repositories set up
    public Product addProduct(Product product){
        return null;
        //TODO: to implement
    }
    public boolean removeProduct (Long id){
        return false;
        // TODO: to implement
    }

}
