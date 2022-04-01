package uz.protshm.recommenduz.service.manufacturer;

import uz.protshm.recommenduz.dto.CategoryDto;
import uz.protshm.recommenduz.dto.CategoryForm;
import uz.protshm.recommenduz.dto.ManufacturerDto;
import uz.protshm.recommenduz.dto.ManufacturerForm;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto add(ManufacturerForm form);

    ManufacturerDto update(ManufacturerForm form, Long id);

    void delete(Long id);

    ManufacturerDto getOne(Long id);

    List<ManufacturerDto> findAll();


}

