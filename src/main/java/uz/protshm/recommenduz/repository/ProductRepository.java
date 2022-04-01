package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.Product;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByDeletedFalseAndId(Long id);




}
