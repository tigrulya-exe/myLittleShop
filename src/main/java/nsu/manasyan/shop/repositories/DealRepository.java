package nsu.manasyan.shop.repositories;

import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository {
    Deal getDeal(String dealId);
    Deal updateDeal(String dealId, Product product, int amount);
}
