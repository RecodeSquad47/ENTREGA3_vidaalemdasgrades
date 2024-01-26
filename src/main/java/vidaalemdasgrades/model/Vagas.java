package vidaalemdasgrades.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vagas")
public class Vagas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String telefone;

    @ManyToMany(mappedBy="vagas")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresas empresa;

}
