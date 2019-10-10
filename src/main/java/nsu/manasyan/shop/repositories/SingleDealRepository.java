package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.json.JsonParser;
import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class SingleDealRepository implements DealRepository{
    // in this task we have only one deal
    private Deal deal;

    private static final String DEAL_PATH = "deal.json";

    public SingleDealRepository() throws IOException {
        deal = new ObjectMapper().readValue(JsonParser.class.getClassLoader().getResourceAsStream(DEAL_PATH), Deal.class);
    }

    public Deal updateDeal(String dealId, String productName, int productAmount){
        deal.updateCart(productName, productAmount);
        return deal;
    }

    @Override
    public Deal getDeal(String dealId) {
        return deal;
    }
}
