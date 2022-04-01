package uz.protshm.recommenduz.entities;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Feedback extends BaseEntity{
    @ManyToOne
    private Product product;
    private int starts;
    private String advantage;
    private String disadvantage;
    private String comment;
    @Embedded
    private Viewer viewer;
    private Boolean confirmed;
}
