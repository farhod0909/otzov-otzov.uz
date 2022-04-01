package uz.protshm.recommenduz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.protshm.recommenduz.entities.Category;
import uz.protshm.recommenduz.entities.Feature;
import uz.protshm.recommenduz.entities.LocalizedString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureForm {

    private String uz;
    private String ru;
    private String en;
    private Long productId;

//    public static Feature toEntity(FeatureForm form){
//        Feature feature=new Feature();
//        feature.setName(new LocalizedString(form.getUz(), form.getRu(), form.getEn()));
//        return feature;
//
//    }




}
