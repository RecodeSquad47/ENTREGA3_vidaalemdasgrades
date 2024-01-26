package vidaalemdasgrades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vidaalemdasgrades.model.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long> {

}
