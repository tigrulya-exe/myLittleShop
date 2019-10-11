package nsu.manasyan.shop.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import nsu.manasyan.shop.models.Deal;
import nsu.manasyan.shop.models.Product;
import nsu.manasyan.shop.util.ServerProperties;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class JsonSingleDealRepository implements DealRepository{

    // in this variant we have only one deal
    private Deal deal;

    private ObjectMapper mapper = new ObjectMapper();

    private String DEAL_PATH;

    public JsonSingleDealRepository() throws IOException {
        String dealJsonFileName = ServerProperties.getProperty("DEAL_JSON_PATH");
        DEAL_PATH = DealRepository.class.getClassLoader().getResource(dealJsonFileName).getPath();
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
            System.out.println(e.getLocalizedMessage());
        }
    }
}
