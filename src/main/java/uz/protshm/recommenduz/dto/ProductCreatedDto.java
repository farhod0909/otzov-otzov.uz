package uz.protshm.recommenduz.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;


import lombok.Data;

@Data
public class ProductCreatedDto {
    @NotBlank
    private String name;
    private List<@NotBlank String> photos;
}
