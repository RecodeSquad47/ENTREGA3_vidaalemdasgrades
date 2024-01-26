package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vidaalemdasgrades.model.Vagas;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Long> {

}

