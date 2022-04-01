package uz.protshm.recommenduz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LocalizedString {
    private String uz;
    private String ru;
    private String en;
}
