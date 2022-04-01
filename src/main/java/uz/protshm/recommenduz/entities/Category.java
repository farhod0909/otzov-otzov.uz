package uz.protshm.recommenduz.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    @Embedded
    private LocalizedString name;

    public LocalizedString getName() {
        return name;
    }
}
