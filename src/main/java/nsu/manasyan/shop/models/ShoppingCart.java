package nsu.manasyan.shop.models;

import java.util.Map;

public class ShoppingCart {
    private String id;

    private Customer holder;

    private Map<String, CartContext> products;

    private int sum;

    public Map<String, CartContext> getProducts() {
        return products;
    }

    public void setProducts(Map<String, CartContext> products) {
        this.products = products;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Customer getHolder() {
        return holder;
    }

    public void setHolder(Customer holder) {
        this.holder = holder;
        this.id = holder.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void putProduct(Product product, int amount){
        products.put(product.getName(),new CartContext(product,amount));
        updateSum();
    }

    public void deleteProduct(String productName){
        products.remove(productName);
    }

    public void clear(){
        products.clear();

    }

    private void updateSum(){
        sum = 0;
        products.values().forEach(c -> sum += c.getSum());
    }

}
