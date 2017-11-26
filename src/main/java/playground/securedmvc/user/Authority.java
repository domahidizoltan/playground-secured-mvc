package playground.securedmvc.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Authority implements GrantedAuthority {

    @Id
    int id;

    Role role;

    @Column(name = "authority", length = 80)
    String authority;

}
