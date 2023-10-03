package com.dimathicc.shareit.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userDTOToUser(UserDTO userDTO) throws UserNotFoundException {
        User user = new User();
        user.setId(userRepository.findIdByName(userDTO.getName()));
        if (user.getId() == -1) throw new UserNotFoundException("User not found");
        user.setName(userDTO.getName());
        user.setItems(userDTO.getItems());
        return user;
    }

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setItems(user.getItems());
        return userDTO;
    }
}
