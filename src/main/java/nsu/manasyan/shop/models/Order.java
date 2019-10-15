package nsu.manasyan.shop.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

public class Order {
    private String id = UUID.randomUUID().toString();
    private ShoppingCart shoppingCart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date date;

    public Order(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        date = new Date();
    }

    public String getId() {
        return id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Date getDate() {
        return date;
    }
}
