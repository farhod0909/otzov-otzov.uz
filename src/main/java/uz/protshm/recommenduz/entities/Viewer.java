package uz.protshm.recommenduz.entities;

import lombok.Data;

import javax.persistence.Embeddable;
@Data
@Embeddable
public class Viewer {
    private String name;
    private String email;
}
