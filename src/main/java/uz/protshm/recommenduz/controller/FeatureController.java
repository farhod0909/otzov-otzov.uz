package uz.protshm.recommenduz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;
import uz.protshm.recommenduz.dto.FeatureDto;
import uz.protshm.recommenduz.dto.FeatureForm;
import uz.protshm.recommenduz.repository.FeatureRepository;
import uz.protshm.recommenduz.service.category.CategoryService;
import uz.protshm.recommenduz.service.feature.FeatureServiceImp;

import java.util.List;


@RestController
@RequestMapping("/api/v1/feature")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureServiceImp service;

    @PostMapping
    public FeatureDto add(@RequestBody FeatureForm form) {
        return service.add(form);
    }

    @GetMapping
    public List<FeatureDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FeatureDto getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public FeatureDto update(@PathVariable Long id, @RequestBody FeatureForm form) {
        return service.update(form, id);
    }
}