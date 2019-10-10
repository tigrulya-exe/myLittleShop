package nsu.manasyan.shop.repositories;

import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository {
    public Product getProduct(String productName);
    public void updateProduct(Product product);
}
