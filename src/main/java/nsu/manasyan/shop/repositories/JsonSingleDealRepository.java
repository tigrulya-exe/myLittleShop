package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.Product;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class JsonSingleDealRepository implements DealRepository{
    // in this task we have only one deal
    private Deal deal;

    private ObjectMapper mapper = new ObjectMapper();

    private static final String DEAL_PATH = DealRepository.class.getClassLoader().getResource("deal.json").getPath();

    public JsonSingleDealRepository() throws IOException {
        deal = mapper.readValue(new File(DEAL_PATH), Deal.class);
    }

    public Deal updateDeal(String dealId, Product product, int productAmount) {
        deal.updateCart(product, productAmount);
        serialize();
        return deal;
    }

    @Override
    public Deal getDeal(String dealId) {
        return deal;
    }

    private void serialize() {
        try {
            mapper.writeValue(new File(DEAL_PATH), deal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
