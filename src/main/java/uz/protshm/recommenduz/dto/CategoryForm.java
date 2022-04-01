package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.LocalizedString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {
    private String uz;
    private String ru;
    private String en;


    public static Category toEntity(CategoryForm form) {
        Category category = new Category();
        category.setName(new LocalizedString(form.getUz(), form.getRu(), form.getEn()));
        return category;
    }


}
