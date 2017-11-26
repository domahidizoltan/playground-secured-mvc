package playground.securedmvc.config;

import playground.securedmvc.security.Authentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Authentication authentication;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public SecurityConfiguration(Authentication authentication, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authentication = authentication;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        try {
            authentication.configure(httpSecurity);
        } catch (Exception ex) {
            log.error("Could not configure authentication.", ex);
        }
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authentication.configure(authenticationManagerBuilder);
    }

}
