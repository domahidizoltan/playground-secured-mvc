package playground.securedmvc.security;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
@Profile("disabled-security")
public class DisabledAuthentication implements Authentication {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {

    }
}
