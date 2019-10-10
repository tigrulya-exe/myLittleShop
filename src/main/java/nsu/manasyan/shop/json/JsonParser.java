package nsu.manasyan.shop.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonParser <T>{
        private ObjectMapper mapper = new ObjectMapper();

    public T getObjFromJson(String path, Class<T> tClass) throws IOException {
        return mapper.readValue(JsonParser.class.getClassLoader().getResourceAsStream(path), tClass);
    }

}
