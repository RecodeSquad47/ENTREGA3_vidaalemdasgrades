package vidaalemdasgrades.service.impl;

import java.util.List;

import vidaalemdasgrades.dto.UserDto;
import vidaalemdasgrades.model.User;


public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
