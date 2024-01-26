package vidaalemdasgrades.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empresas")
public class Empresas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CNPJ;
	private String descricao;
	private String telefone;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Vagas> vagas;

}
