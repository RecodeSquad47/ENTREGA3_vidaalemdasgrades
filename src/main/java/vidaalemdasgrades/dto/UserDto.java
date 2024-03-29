package vidaalemdasgrades.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto
{
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty(message = "O e-mail não deve estar vazio")
    @Email
    private String email;
    @NotEmpty(message = "A senha não deve estar vazia")
    private String password;
}
