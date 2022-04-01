package uz.protshm.recommenduz.entities;

import lombok.*;
import uz.protshm.recommenduz.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users extends BaseEntity {
    @Column(unique = true,length = 128)
    private String username;
    private String password;
    @Column(length = 128)
    private String fullName;
    @Enumerated(EnumType.STRING) @Column(length = 64)
    private UserRole role;
    private Boolean blocked;
}
