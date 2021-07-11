package klyanskis.java.bootstrap.service;

import klyanskis.java.bootstrap.model.Role;
import klyanskis.java.bootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(User user);
    void update(User user);
    User getById(long id);
    User getByName(String name);
    Role getRoleByName(String name);
    List<String> getAll();
}

