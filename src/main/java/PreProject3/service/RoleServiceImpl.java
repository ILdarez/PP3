package PreProject3.service;

import PreProject3.dao.RoleDao;
import PreProject3.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Set<Role> getRolesByNames(Set<String> roleNames) {
        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            roleDao.findByName(roleName).ifPresent(roles::add);
        }
        return roles;
    }
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }
    @Transactional(readOnly = true)
    public Role findByName(String name) {
        return roleDao.findByName(name).orElse(null);
    }
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }

}