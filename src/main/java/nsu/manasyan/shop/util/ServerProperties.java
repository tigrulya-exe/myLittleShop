package nsu.manasyan.shop.util;

import nsu.manasyan.shop.exceptions.NotFoundException;
import nsu.manasyan.shop.repositories.ProductsRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ServerProperties {
    private static final String PROPERTIES_PATH = "server.properties";

    private static Properties properties = new Properties();

    static {
        try(InputStream propertiesStream = ProductsRepository.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH)) {
            if (propertiesStream == null){
                throw new NotFoundException("Properties not found");
            }
            properties.load(propertiesStream);
        }catch (IOException exception){
            System.out.println(exception.getLocalizedMessage());
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
