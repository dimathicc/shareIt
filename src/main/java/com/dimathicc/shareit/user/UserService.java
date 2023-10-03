package com.dimathicc.shareit.user;


import java.util.List;

public interface UserService {
    User findOwnerByUserId(long userId);
    UserDTO findUserById(long userId);
    List<UserDTO> findAll();
    UserDTO create(UserDTO userDTO) throws UserNotFoundException;
    UserDTO update(int userId, UserDTO userDTO) throws UserNotFoundException;
    User delete(long userId);
}
