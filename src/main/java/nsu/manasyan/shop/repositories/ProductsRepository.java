package nsu.manasyan.shop.repositories;

import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository {
    Product getProduct(String productName);
}
