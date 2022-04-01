package uz.protshm.recommenduz.controller;

import javax.validation.Valid;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.protshm.recommenduz.dto.ProductCreatedDto;
import uz.protshm.recommenduz.dto.ProductDto;
import uz.protshm.recommenduz.service.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductDto add(@RequestBody @Valid ProductCreatedDto dto) {
        return service.add(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id,@RequestBody ProductDto dto){
        return  service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id){
        service.delete(id);
    }

}




