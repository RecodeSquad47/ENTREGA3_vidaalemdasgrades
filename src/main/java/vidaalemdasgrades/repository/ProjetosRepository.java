package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vidaalemdasgrades.model.Projetos;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {

}

 