package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vidaalemdasgrades.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {

}

