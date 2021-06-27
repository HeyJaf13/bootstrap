package klyanskis.java.bootstrap.dao;

import klyanskis.java.bootstrap.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void add(User user);
    void delete(User user);
    void update(User user);
    User getById(long id);
    User getByName(String name);
}
