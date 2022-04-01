package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.Manufacturer;


public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
