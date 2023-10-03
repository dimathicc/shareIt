package com.dimathicc.shareit.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User findOwnerByUserId(long userId) {
        return userRepository.findOwnerByUserId(userId);
    }

    @Override
    public UserDTO findUserById(long userId) {
        return mapper.userToUserDTO(userRepository.findUserById(userId));
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(mapper.userToUserDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO create(UserDTO userDTO) throws UserNotFoundException {
        userRepository.create(mapper.userDTOToUser(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO update(int userId, UserDTO userDTO) throws UserNotFoundException {
        User user = mapper.userDTOToUser(userDTO);
        userRepository.update(userId, user);
        return userDTO;
    }
    @Override
    public User delete(long userId) {
        return userRepository.delete(userId);
    }
}
