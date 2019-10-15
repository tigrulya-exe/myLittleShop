package nsu.manasyan.shop.api;

import io.swagger.annotations.ApiOperation;
import nsu.manasyan.shop.models.CartUpdateTO;
import nsu.manasyan.shop.models.Order;
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

    @GetMapping(BARTER_PATH + "/carts/{cartId}/order")
    @ApiOperation(value = "Получение данных о текущем заказе")
    public ResponseEntity<Order> getOrder(
            @PathVariable String cartId) {

        return shopService.getDeal(cartId);
    }

    // update products, which are in updatedProducts list
    @PatchMapping(BARTER_PATH + "/carts/{cartId}")
    @ApiOperation(value = "Обновление корзины без удаления необновленных продуктов")
    public ResponseEntity<ShoppingCart> updateShoppingCart(
            @PathVariable String cartId,
            // we can use Map<String, Integer> instead of List<CartUpdateTO>,
            // but option with list was chosen for extensibility
            @RequestBody List<CartUpdateTO> updatedProducts) {

        return shopService.updateShoppingCart(updatedProducts,cartId);
    }

    // update and delete products, which are not in updatedProducts list
    @PutMapping(BARTER_PATH + "/carts/{cartId}")
    @ApiOperation(value = "Полное обновление корзины (удаление необновленных продуктов)")
    public ResponseEntity<ShoppingCart> renewShoppingCart(
            @PathVariable String cartId,
            @RequestBody List<CartUpdateTO> updatedProducts) {

        return shopService.renewShoppingCart(updatedProducts,cartId);
    }

    @DeleteMapping(BARTER_PATH + "/carts/{cartId}/{productName}")
    @ApiOperation(value = "Удалить предмет из корзины")
    public ResponseEntity<ShoppingCart> deleteProductFromShoppingCart(
            @PathVariable String cartId,
            @PathVariable String productName) {

        return shopService.deleteProductFromShoppingCart(cartId, productName);
    }
}
