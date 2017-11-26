package playground.securedmvc.security;

import playground.securedmvc.security.exception.AccountDisabledException;
import playground.securedmvc.user.Authority;
import playground.securedmvc.user.AuthorityRepository;
import playground.securedmvc.user.User;
import playground.securedmvc.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DatabaseAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public DatabaseAuthenticationProvider(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Authentication: " + authentication);
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();

        Optional<User> user = userRepository.findById(email);

        userCouldLogIn(user, password);

        List<Authority> authorities = authorityRepository.findAllByRole(user.get().getRole());
        log.debug("User has authorities: " + authorities);
        return new UsernamePasswordAuthenticationToken(email, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private void userCouldLogIn(Optional<User> user, String password) {
        if (!user.isPresent() || !user.get().getPassword().equals(password)) {
            throw new BadCredentialsException("Bad credentials");
        }

        if (!user.get().isEnabled()) {
            throw new AccountDisabledException("Account is disabled");
        }
    }

}
