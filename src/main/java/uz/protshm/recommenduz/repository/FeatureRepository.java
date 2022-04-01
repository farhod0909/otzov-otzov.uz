package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.Feature;

import java.util.List;
import java.util.Optional;


public interface FeatureRepository extends JpaRepository<Feature, Long> {

    List<Feature> findAllByDeletedFalse();
    Optional<Feature> findByIdAndDeletedFalse(Long id);
}
