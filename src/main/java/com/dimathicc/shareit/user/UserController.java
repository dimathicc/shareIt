package com.dimathicc.shareit.user;

import com.dimathicc.shareit.user.dto.UserDTO;
import com.dimathicc.shareit.user.exception.UserNotFoundException;
import com.dimathicc.shareit.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/debug")
    public List<User> findAllDebug() {
        return userService.debug();
    }

    @GetMapping("/{userId}")
    public UserDTO findUserById(@PathVariable long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO userDTO) throws UserNotFoundException {
        return userService.create(userDTO);
    }

    @PutMapping("/{userId}")
    public UserDTO update(@PathVariable int userId, @RequestBody UserDTO userToBeUpdated) throws UserNotFoundException {
        return userService.update(userId, userToBeUpdated);
    }

    @DeleteMapping("/{userId}")
    public User delete(@PathVariable int userId) {
        return userService.delete(userId);
    }
}
