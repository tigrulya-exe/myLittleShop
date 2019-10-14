package nsu.manasyan.shop.models;

import nsu.manasyan.shop.exceptions.NotFoundException;
import nsu.manasyan.shop.services.ShopService;

import java.net.PortUnreachableException;
import java.util.Map;

public class ShoppingCart {
    private Map<String, CartContext> products;

    private int sum;

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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void updateProduct(Product product, int amount){
        products.put(product.getName(),new CartContext(product,amount));
        updateSum();
    }

    public void clear(){
        products.clear();
    }

    private void updateSum(){
        sum = 0;
        products.values().forEach(c -> sum += c.getSum());
    }

}
