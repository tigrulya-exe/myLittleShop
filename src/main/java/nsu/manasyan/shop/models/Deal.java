package nsu.manasyan.shop.models;

import java.util.Date;

public class Deal {
//    private String id = UUID.randomUUID().toString();
    private String id;
    private Customer customer;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void updateCart(String productName, int amount){
        getCustomer().getShoppingCart().updateProduct(productName, amount);
    }
}
