package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.LocalizedString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto toDto(Category c) {

        String title;
        switch ("user tanlagan tili") {
            case "ru":
                title = c.getName().getRu();
                break;
            case "en":
                title = c.getName().getEn();
                break;
            case "uz":
            default:
                title = c.getName().getUz();
        }
        return new CategoryDto(c.getId(), title);
    }
}
