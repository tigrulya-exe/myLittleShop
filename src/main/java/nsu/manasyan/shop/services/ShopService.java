package nsu.manasyan.shop.services;

import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.DealUpdateTO;
import nsu.manasyan.shop.repositories.DealRepository;
import nsu.manasyan.shop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private ProductsRepository productsRepository;

    public ResponseEntity<Deal> getDeal(String dealId) {
        return ResponseEntity.ok(dealRepository.getDeal(dealId));
    }

    public ResponseEntity<Deal> updateDeal(List<DealUpdateTO> updatedProducts, String dealId) {
        checkProductsExistence(updatedProducts);
        updatedProducts.forEach(p -> dealRepository.updateDeal(dealId,p.getProductName(),p.getCount()));
        return ResponseEntity.ok(dealRepository.getDeal(dealId));
    }

    // TODO mb redo: add check method in repository
    private void checkProductsExistence(List<DealUpdateTO> updatedProducts){
        updatedProducts.forEach(v -> productsRepository.getProduct(v.getProductName()));
    }
}
