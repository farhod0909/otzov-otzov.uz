package uz.protshm.recommenduz.service.product;

import org.springframework.http.ResponseEntity;
import uz.protshm.recommenduz.dto.ProductCreatedDto;
import uz.protshm.recommenduz.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto add(ProductCreatedDto dto);

    ProductDto update(Long id, ProductDto dto);

    void delete(Long id);

    ProductDto getOne(Long id);

    ResponseEntity<List<ProductDto>> findAll();


}
