package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vidaalemdasgrades.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}