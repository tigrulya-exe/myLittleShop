package nsu.manasyan.shop.api;

import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.DealUpdateTO;
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

    @GetMapping(BARTER_PATH + "/deals/{dealId}")
    public ResponseEntity<Deal> getDeal(
            @PathVariable String dealId) {

        return shopService.getDeal(dealId);
    }

    @PatchMapping(BARTER_PATH + "/deals/{dealId}")
    public ResponseEntity<Deal> updateDeal(
            @PathVariable String dealId,
            @RequestBody List<DealUpdateTO> updatedProducts) {

        return shopService.updateDeal(updatedProducts,dealId);
    }
}
