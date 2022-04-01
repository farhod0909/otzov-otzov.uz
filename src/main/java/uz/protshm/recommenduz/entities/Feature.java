package uz.protshm.recommenduz.entities;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Data
@Entity

public class Feature extends BaseEntity{
    @Embedded
    private LocalizedString name;
    @ManyToOne
    private Product product;





}

