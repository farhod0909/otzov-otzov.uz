package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.FileItem;

import java.util.Optional;


public interface FileItemRepository extends JpaRepository<FileItem, Long> {

    Optional<FileItem> findByUidAndDeletedFalse(String uid);
    FileItem getByUid(String uid);

    Boolean existsByUid(String uid);
}
