package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void removeUserById(int id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);
}
