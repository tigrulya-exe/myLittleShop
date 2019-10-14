package nsu.manasyan.shop.api;

import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.DealUpdateTO;
import nsu.manasyan.shop.models.ShoppingCart;
import nsu.manasyan.shop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    private static final String BARTER_PATH = "/api/shop";

    @GetMapping(BARTER_PATH + "/carts/{cartId}/deal")
    public ResponseEntity<Deal> getDeal(
            @PathVariable String cartId) {

        return shopService.getDeal(cartId);
    }

    // we can use Map<String, Integer> instead of List<DealUpdateTO>,
    // but option with list was chosen for extensibility
    @PatchMapping(BARTER_PATH + "/carts/{dealId}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(
            @PathVariable String dealId,
            @RequestBody List<DealUpdateTO> updatedProducts) {

        return shopService.updateShoppingCart(updatedProducts,dealId);
    }

    // update and delete products, which are not in updatedProducts list
    @PutMapping(BARTER_PATH + "/carts/{dealId}")
    public ResponseEntity<ShoppingCart> renewShoppingCart(
            @PathVariable String dealId,
            @RequestBody List<DealUpdateTO> updatedProducts) {

        return shopService.renewShoppingCart(updatedProducts,dealId);
    }

    @DeleteMapping(BARTER_PATH + "/carts/{dealId}/{productName}")
    public ResponseEntity<ShoppingCart> deleteProductFromShoppingCart(
            @PathVariable String dealId,
            @PathVariable String productName) {

        return shopService.deleteProductFromShoppingCart(dealId, productName);
    }
}
