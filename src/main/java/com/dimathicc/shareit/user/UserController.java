package com.dimathicc.shareit.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    private UserDTO findUserById(@PathVariable long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping
    private List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    private UserDTO create(@RequestBody UserDTO userDTO) throws UserNotFoundException {
        return userService.create(userDTO);
    }

    @PutMapping("/{userId}")
    private UserDTO update(@PathVariable int userId, @RequestBody UserDTO userToBeUpdated) throws UserNotFoundException {
        return userService.update(userId, userToBeUpdated);
    }

    @DeleteMapping("/{userId}")
    private User delete(@PathVariable int userId) {
        return userService.delete(userId);
    }
}
