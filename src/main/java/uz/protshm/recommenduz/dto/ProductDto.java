package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.protshm.recommenduz.entities.FileItem;
import uz.protshm.recommenduz.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    List<String> photos;

    public static ProductDto toDto(Product save) {
        ProductDto productDto = new ProductDto();
        productDto.setId(save.getId());
        productDto.setName(save.getName());
        List<String> photosUid = new ArrayList<>();
        for (FileItem photo : save.getPhotos()) {
            photosUid.add(photo.getUid());
        }
        productDto.setPhotos(photosUid);
        return productDto;
    }
}
