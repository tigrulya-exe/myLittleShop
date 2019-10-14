package nsu.manasyan.shop.repositories;

import nsu.manasyan.shop.models.Product;
import nsu.manasyan.shop.models.ShoppingCart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    ShoppingCart getCart(String cartId);
    ShoppingCart updateCart(String cartId, Product product, int amount);
}
