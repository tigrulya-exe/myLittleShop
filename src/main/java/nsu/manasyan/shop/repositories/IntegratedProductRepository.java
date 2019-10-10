package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.exceptions.NotFoundException;
import nsu.manasyan.shop.json.JsonParser;
import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

@Repository
public class IntegratedProductRepository implements ProductsRepository {
    private static final String PRODUCTS_PATH = "products.json";
    // key - name, value - price
    private Map<String, Integer> products;

    public IntegratedProductRepository() throws IOException {
        products = new ObjectMapper().readValue(JsonParser.class.getClassLoader().getResourceAsStream(PRODUCTS_PATH), Map.class);
    }

    @Override
    public Product getProduct(String productName) {
        Integer price;
        if((price = products.get(productName)) == null){
            throw new NotFoundException("WrongProductName");
        }
        return new Product(productName, price);
    }

    // TODO zachem
    @Override
    public void updateProduct(Product product) {
        // check
        getProduct(product.getName());
        products.put(product.getName(), product.getPrice());
    }
}
