package uz.protshm.recommenduz.service.feature;

import uz.protshm.recommenduz.dto.FeatureDto;
import uz.protshm.recommenduz.dto.FeatureForm;

import java.util.List;

public interface FeatureService {

    FeatureDto add(FeatureForm form);

    FeatureDto update(FeatureForm form,Long id);

    void delete(Long id);

    FeatureDto getOne(Long id);

    List<FeatureDto> findAll();





}
