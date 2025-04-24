package PreProject3.repositories;

import PreProject3.model.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @EntityGraph(attributePaths = {"users"})
    Optional<Role> findByName(String name);

    @EntityGraph(attributePaths = {"users"})
    List<Role> findAllByIdIn(Collection<Long> ids);
}
