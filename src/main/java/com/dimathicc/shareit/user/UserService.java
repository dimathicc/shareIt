package com.dimathicc.shareit.user;


import com.dimathicc.shareit.user.dto.UserDTO;
import com.dimathicc.shareit.user.exception.UserNotFoundException;
import com.dimathicc.shareit.user.model.User;

import java.util.List;

public interface UserService {
    User findOwnerByUserId(long userId);
    UserDTO findUserById(long userId);
    List<UserDTO> findAll();
    UserDTO create(UserDTO userDTO) throws UserNotFoundException;
    UserDTO update(int userId, UserDTO userDTO) throws UserNotFoundException;
    User delete(long userId);

    List<User> debug();
}
