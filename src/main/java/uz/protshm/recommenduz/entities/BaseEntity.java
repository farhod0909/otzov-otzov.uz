package uz.protshm.recommenduz.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Instant created;
    @LastModifiedDate
    private Instant updated;
    @CreatedBy
    private Long createdBy;
    @LastModifiedBy
    private Long modifiedBy;
    private Boolean deleted = false;

}
