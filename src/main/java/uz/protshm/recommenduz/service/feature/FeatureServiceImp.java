package uz.protshm.recommenduz.service.feature;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.protshm.recommenduz.dto.FeatureDto;
import uz.protshm.recommenduz.dto.FeatureForm;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.LocalizedString;
import uz.protshm.recommenduz.entities.Product;
import uz.protshm.recommenduz.repository.FeatureRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServiceImp implements FeatureService {

    private final FeatureRepository repository;
    private final EntityManager manager;

    @Override
    public FeatureDto add(FeatureForm form) {
        Feature feature = toEntity(form, new Feature());
        repository.save(feature);
        return FeatureDto.toDto(feature);


    }

    @Override
    public FeatureDto update(FeatureForm form, Long id) {
//        Feature feature = get(id);
//        feature.setName(new LocalizedString(form.getUz(), form.getRu(), form.getEn()));
//        repository.save(feature);
//        return FeatureDto.toDto(feature);
        return FeatureDto.toDto(repository.save(toEntity(form, get(id))));
    }

    @Override
    public void delete(Long id) {
        //repository.delete(get(id));
        Feature feature = get(id);
        feature.setDeleted(true);
        repository.save(feature);
    }

    @Override
    public FeatureDto getOne(Long id) {
        return FeatureDto.toDto(get(id));
    }

    @Override
    public List<FeatureDto> findAll() {
        return repository.findAll().stream().map(FeatureDto::toDto).collect(Collectors.toList());
    }

    private Feature get(Long id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new RuntimeException("Feature not found!"));
    }

    private Feature toEntity(FeatureForm from, Feature feature) {
        feature.setName(new LocalizedString(from.getUz(), from.getRu(), from.getEn()));
        feature.setProduct(manager.getReference(Product.class, from.getProductId()));
        return feature;
    }

}