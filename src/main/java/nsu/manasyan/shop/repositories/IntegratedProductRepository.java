package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.exceptions.NotFoundException;
import nsu.manasyan.shop.models.Product;
import nsu.manasyan.shop.util.ServerProperties;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

@Repository
public class IntegratedProductRepository implements ProductsRepository {

    private String PRODUCTS_PATH;
    // key - name, value - price
    private Map<String, Integer> products;

    public IntegratedProductRepository() throws IOException {
        PRODUCTS_PATH = ServerProperties.getProperty("PRODUCTS_JSON_PATH");
        products = new ObjectMapper().readValue(ProductsRepository.class.getClassLoader().getResourceAsStream(PRODUCTS_PATH), Map.class);
    }

    @Override
    public Product getProduct(String productName) {
        Integer price;
        if((price = products.get(productName)) == null){
            throw new NotFoundException("WrongProductName: " + productName);
        }
        return new Product(productName, price);
    }

}
