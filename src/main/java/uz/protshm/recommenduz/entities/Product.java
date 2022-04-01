package uz.protshm.recommenduz.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product extends BaseEntity {
    @OneToMany
    List<FileItem> photos;
    private String name;
}
