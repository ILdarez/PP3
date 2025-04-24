package PreProject3.repositories;

import PreProject3.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"roles"})
    @Query("SELECT u FROM User u WHERE u.email = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findById(Long id);

    boolean existsByEmail(String email);
}
