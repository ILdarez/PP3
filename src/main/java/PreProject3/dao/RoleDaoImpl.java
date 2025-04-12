package PreProject3.dao;

import PreProject3.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Override

    public Optional<Role> findByName(String name) {
        try {
            return Optional.ofNullable(
                    entityManager.createQuery("FROM Role WHERE name = :name", Role.class)
                            .setParameter("name", name)
                            .getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(role -> entityManager.remove(role));
    }

    @Override
    public Role update(Role role) {
        return entityManager.merge(role);
    }
}