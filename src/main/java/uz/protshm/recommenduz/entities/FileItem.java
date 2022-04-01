package uz.protshm.recommenduz.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class FileItem extends BaseEntity{
    private String url;
    private String fileName;
    @Column(unique = true)
    private String uid;
    private String contentType;
    private Long size;
}
