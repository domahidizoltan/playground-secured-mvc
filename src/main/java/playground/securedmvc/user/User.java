package playground.securedmvc.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @Column(name = "email", unique = true, length = 160)
    @Email
    @NotNull
    @Max(160)
    String email;

    @NotNull
    @Max(160)
    String password;

    boolean enabled;

    Role role;
}
