package uz.protshm.recommenduz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;
import uz.protshm.recommenduz.dto.ManufacturerDto;
import uz.protshm.recommenduz.dto.ManufacturerForm;
import uz.protshm.recommenduz.service.category.CategoryService;
import uz.protshm.recommenduz.service.manufacturer.ManufacturerService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/manufacturer")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService service;

    @PostMapping
    public ManufacturerDto add(@RequestBody ManufacturerForm form) {
        return service.add(form);
    }

    @GetMapping
    public List<ManufacturerDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ManufacturerDto getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ManufacturerDto update(@PathVariable Long id, @RequestBody ManufacturerForm form) {
        return service.update(form, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
