package nsu.manasyan.shop.services;

import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.DealUpdateTO;
import nsu.manasyan.shop.models.ShoppingCart;
import nsu.manasyan.shop.repositories.CartRepository;
import nsu.manasyan.shop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductsRepository productsRepository;

    public ResponseEntity<Deal> getDeal(String cartId) {
        Deal deal = new Deal(cartRepository.getCart(cartId));
        return ResponseEntity.ok(deal);
    }

    public ResponseEntity<ShoppingCart> updateShoppingCart(List<DealUpdateTO> updatedProducts, String shoppingCartId){
        updatedProducts.forEach(p -> {
            String productName = p.getProductName();
            int productCount = p.getCount();
            cartRepository.updateCart(shoppingCartId,productsRepository.getProduct(productName),productCount);
        });
        return ResponseEntity.ok(cartRepository.getCart(shoppingCartId));
    }

    public ResponseEntity<ShoppingCart> renewShoppingCart(List<DealUpdateTO> updatedProducts, String cartId){
        ShoppingCart cart = cartRepository.getCart(cartId);
        cart.clear();
        return updateShoppingCart(updatedProducts,cartId);
    }

    public ResponseEntity<ShoppingCart> deleteProductFromShoppingCart(String cartId, String productName){
        ShoppingCart cart = cartRepository.getCart(cartId);
        cart.deleteProduct(productName);
        return ResponseEntity.ok(cartRepository.getCart(cartId));
    }
}
