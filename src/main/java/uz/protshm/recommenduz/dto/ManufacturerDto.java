package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.protshm.recommenduz.entities.Manufacturer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDto {
    private Long id;
    private String name;


    public static ManufacturerDto toDto(Manufacturer manufacturer) {
        String title;
        switch ("to choose name") {
            case "ru":
                title = manufacturer.getName().getRu();
            case "en":
                title = manufacturer.getName().getEn();
            case "uz":
                title = manufacturer.getName().getUz();
            default:
                title = manufacturer.getName().getUz();
        }
        return new  ManufacturerDto(manufacturer.getId(),title);

    }

}
