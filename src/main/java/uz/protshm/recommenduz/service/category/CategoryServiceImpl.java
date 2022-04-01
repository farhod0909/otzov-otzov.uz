package uz.protshm.recommenduz.service.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.LocalizedString;
import uz.protshm.recommenduz.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryDto add(CategoryForm form) {
        Category category=CategoryForm.toEntity(form);
        repository.save(category);
        return CategoryDto.toDto(category);

    }

    @Override
    public CategoryDto update(Long id, CategoryForm form) {
        Category category = get(id);
        category.setName(new LocalizedString(form.getUz(), form.getRu(), form.getEn()));
        repository.save(category);
        return CategoryDto.toDto(category);

    }

    @Override
    public void delete(Long id) {
        repository.delete(get(id));

    }

    @Override
    public CategoryDto getOne(Long id) {
        return CategoryDto.toDto(get(id));
    }

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(CategoryDto::toDto).collect(Collectors.toList());
    }


    private Category get(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Category is not found:" + id);
        });


    }
}



