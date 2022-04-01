package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.protshm.recommenduz.entities.LocalizedString;
import uz.protshm.recommenduz.entities.Manufacturer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerForm {
    private String uz;
    private String en;
    private String ru;


    public static Manufacturer toEntity(ManufacturerForm form) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(new LocalizedString(form.getUz(), form.ru, form.en));
        return manufacturer;

    }


}