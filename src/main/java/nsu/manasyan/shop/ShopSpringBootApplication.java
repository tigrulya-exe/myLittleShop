package nsu.manasyan.shop;

import nsu.manasyan.shop.json.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ShopSpringBootApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ShopSpringBootApplication.class, args);
    }
}

