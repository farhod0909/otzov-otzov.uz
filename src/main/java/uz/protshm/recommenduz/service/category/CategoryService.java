package uz.protshm.recommenduz.service.category;

import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;

import java.util.List;

public interface CategoryService {

    CategoryDto add(CategoryForm form);

    CategoryDto update(Long id, CategoryForm form);

    void delete(Long id);

    CategoryDto getOne(Long id);


     List<CategoryDto> findAll();





}
