package com.dimathicc.shareit.user.dao;

import com.dimathicc.shareit.user.model.User;

import java.util.List;

public interface UserRepository {
    User findUserById(long userId);
    User findOwnerByUserId(long userId);
    List<User> findAll();
    User create(User user);

    void update(int userId, User user);

    User delete (long userId);
    long findIdByName(String name);
}
