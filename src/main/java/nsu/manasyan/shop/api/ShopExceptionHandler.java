package nsu.manasyan.shop.api;

 import nsu.manasyan.shop.exceptions.NotFoundException;
 import nsu.manasyan.shop.models.ErrorTO;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.ExceptionHandler;
 import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShopExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorTO> constructNotFoundEntity(NotFoundException nfe){
        return ResponseEntity.status(404).body(new ErrorTO(nfe.getLocalizedMessage()));
    }
}
