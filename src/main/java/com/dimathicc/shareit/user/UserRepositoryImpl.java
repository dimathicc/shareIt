package com.dimathicc.shareit.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User findUserById(long userId) {
        return users.get((int) userId);
    }

    @Override
    public User findOwnerByUserId(long userId) {
        return users.get((int) userId);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void update(int userId, User user) {
        User newUser = users.get(userId);
        newUser.setName(user.getName());
        newUser.setItems(user.getItems());
        users.remove(user);
        users.add(newUser);
    }

    @Override
    public User delete(long userId) {
        return users.remove((int) userId);
    }

    @Override
    public long findIdByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user.getId();
            }
        }
        return -1;
    }
}
