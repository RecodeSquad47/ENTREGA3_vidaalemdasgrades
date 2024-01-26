package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vidaalemdasgrades.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}