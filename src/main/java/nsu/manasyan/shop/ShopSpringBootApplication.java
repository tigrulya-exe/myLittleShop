package nsu.manasyan.shop;

import nsu.manasyan.shop.json.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopSpringBootApplication {

    public static void main(String[] args) {
        System.out.println(JsonParser.class.getClassLoader().getResource("deal.json").getPath());
        SpringApplication.run(ShopSpringBootApplication.class, args);
    }
}

