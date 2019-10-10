package nsu.manasyan.shop.models;

import nsu.manasyan.shop.exceptions.NotFoundException;

import java.util.Map;

public class ShoppingCart {
    private Map<String, CartContext> products;

    public Map<String, CartContext> getProducts() {
        return products;
    }

    public void setProducts(Map<String, CartContext> products) {
        this.products = products;
    }

    public CartContext getCartContext(String productName){
        CartContext cartContext;
        if((cartContext = products.get(productName)) == null){
            throw new NotFoundException("User doesn't have this product");
        }

        return cartContext;
    }

    public void updateProduct(String productName, int amount){
        CartContext cartContext = getCartContext(productName);
        cartContext.setAmount(amount);
        cartContext.setSum(amount * cartContext.getProduct().getPrice());
    }
}
