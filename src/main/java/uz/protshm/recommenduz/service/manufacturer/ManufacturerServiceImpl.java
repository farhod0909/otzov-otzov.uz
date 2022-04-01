package uz.protshm.recommenduz.service.manufacturer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.ManufacturerDto;
import uz.protshm.recommenduz.dto.ManufacturerForm;
import uz.protshm.recommenduz.entities.LocalizedString;
import uz.protshm.recommenduz.entities.Manufacturer;
import uz.protshm.recommenduz.repository.ManufacturerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository repository;

    @Override
    public ManufacturerDto add(ManufacturerForm form) {
        Manufacturer manufacturer = ManufacturerForm.toEntity(form);
        repository.save(manufacturer);
        return ManufacturerDto.toDto(manufacturer);
    }

    @Override
    public ManufacturerDto update(ManufacturerForm form, Long id) {
        Manufacturer manufacturer = get(id);
        manufacturer.setName(new LocalizedString(form.getUz(), form.getRu(), form.getEn()));
        repository.save(manufacturer);
        return ManufacturerDto.toDto(manufacturer);
    }

    @Override
    public void delete(Long id) {
        repository.delete(get(id));
    }

    @Override
    public ManufacturerDto getOne(Long id) {
        return ManufacturerDto.toDto(get(id));
    }

    @Override
    public List<ManufacturerDto> findAll() {
        return repository.findAll().stream().map(ManufacturerDto::toDto).collect(Collectors.toList());

    }


    private Manufacturer get(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Manufacturer id is not" + id);
        });

    }
}
