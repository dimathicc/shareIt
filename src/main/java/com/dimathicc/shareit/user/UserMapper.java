package com.dimathicc.shareit.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final UserRepository userRepository;
    private long id;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userRepository.findIdByName(userDTO.getName()));

        if (user.getId() == -1) user.setId(id++);
        user.setName(userDTO.getName());
        return user;
    }

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        return userDTO;
    }
}
