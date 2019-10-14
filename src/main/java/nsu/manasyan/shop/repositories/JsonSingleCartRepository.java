package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.models.Product;
import nsu.manasyan.shop.models.ShoppingCart;
import nsu.manasyan.shop.util.ServerProperties;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class JsonSingleCartRepository implements CartRepository {
    private static final String CART_PROPERTY_NAME = "CART_JSON_PATH";

    // in this implementation we have only one cart
    private ShoppingCart shoppingCart;

    private ObjectMapper mapper = new ObjectMapper();

    private String CART_PATH;

    public JsonSingleCartRepository() throws IOException {
        String dealJsonFileName = ServerProperties.getProperty(CART_PROPERTY_NAME);
        CART_PATH = CartRepository.class.getClassLoader().getResource(dealJsonFileName).getPath();
        shoppingCart = mapper.readValue(new File(CART_PATH), ShoppingCart.class);
    }

    public ShoppingCart updateCart(String cartId, Product product, int productAmount) {
        shoppingCart.putProduct(product, productAmount);
        serialize();
        return shoppingCart;
    }

    @Override
    public ShoppingCart getCart(String cartId) {
        return shoppingCart;
    }

    private void serialize() {
        try {
            mapper.writeValue(new File(CART_PATH), shoppingCart);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
