package uz.protshm.recommenduz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;
import uz.protshm.recommenduz.service.category.CategoryService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public CategoryDto add(@RequestBody CategoryForm form) {
        return service.add(form);
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
