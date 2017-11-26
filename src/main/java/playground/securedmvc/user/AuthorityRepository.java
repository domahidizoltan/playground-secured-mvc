package playground.securedmvc.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

    List<Authority> findAllByRole(Role role);
}
