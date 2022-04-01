package uz.protshm.recommenduz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
