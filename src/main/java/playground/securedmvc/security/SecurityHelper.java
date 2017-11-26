package playground.securedmvc.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SecurityHelper {

    public static boolean userHasAnyAuthorities(String... authorities) {
        if (authorities.length <= 0) {
            return false;
        }

        Collection<? extends GrantedAuthority> userAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> desiredAuthorities = Arrays.asList(authorities);
        return userAuthorities.stream().anyMatch(aut -> desiredAuthorities.contains(aut.getAuthority()));
    }


}
