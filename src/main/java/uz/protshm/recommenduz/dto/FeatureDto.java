package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uz.protshm.recommenduz.entities.Feature;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FeatureDto {
    private Long id;
    private String name;
    private Long productId;

    public static FeatureDto toDto(Feature feature) {
        String title;
        switch ("choose the language") {

            case "ru":
                title = feature.getName().getRu();
                break;

            case "en":
                title = feature.getName().getEn();
                break;
            default:
                title = feature.getName().getUz();
        }
        return new FeatureDto(feature.getId(),title,feature.getProduct().getId());


    }


}
