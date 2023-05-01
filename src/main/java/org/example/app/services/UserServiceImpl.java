package org.example.app.services;

import org.example.app.domain.User;
import org.example.app.exceptions.UserException;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceImpl implements UserService {

    private final HashMap<Long, User> map;

    public UserServiceImpl() {
        map = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUser() {
        return map.values();
    }

    @Override
    public User getUser(Long id) {
        return map.get(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {
            if (user.getId() == null)
                throw new UserException("ID required");

            User empEdit = map.get(user.getId());

            if (empEdit == null)
                throw new UserException("User not found");

            if (user.getEmail() != null) {
                empEdit.setEmail(user.getEmail());
            }

            if (user.getPhone() != null) {
                empEdit.setPhone(user.getPhone());
            }

            if (user.getName() != null) {
                empEdit.setName(user.getName());
            }

            if (user.getId() != null) {
                empEdit.setId(user.getId());
            }

            return user;
        } catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        map.remove(id);
    }
}
