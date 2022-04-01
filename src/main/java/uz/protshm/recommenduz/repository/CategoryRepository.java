package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.BaseEntity;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.LocalizedString;

import javax.persistence.Entity;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
