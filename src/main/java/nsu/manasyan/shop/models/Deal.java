package nsu.manasyan.shop.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.UUID;

public class Deal {
    private String id = UUID.randomUUID().toString();
    private ShoppingCart shoppingCart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date date;

    public Deal(ShoppingCart shoppingCart) {
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
