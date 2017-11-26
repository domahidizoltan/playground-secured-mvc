package playground.securedmvc.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface Authentication {

    void configure(HttpSecurity httpSecurity) throws Exception;

    void configure(AuthenticationManagerBuilder authenticationManagerBuilder);

}
