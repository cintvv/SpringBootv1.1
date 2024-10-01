package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Component
public interface UserDao {
    void saveUser(User user);

    void removeUserById(int id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);
}
