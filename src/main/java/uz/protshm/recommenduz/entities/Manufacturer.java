package uz.protshm.recommenduz.entities;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Data
public class Manufacturer extends BaseEntity {
    @Embedded
    private LocalizedString name;
}
