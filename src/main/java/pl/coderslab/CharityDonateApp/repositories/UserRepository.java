package pl.coderslab.CharityDonateApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.CharityDonateApp.entities.CharityUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CharityUser, Long> {
    boolean existsByEmail(String email);
    Optional<CharityUser> findByEmail(String email);
}
