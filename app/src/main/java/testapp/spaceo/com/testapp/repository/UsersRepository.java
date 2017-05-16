package testapp.spaceo.com.testapp.repository;


import java.util.Collection;

import testapp.spaceo.com.testapp.model.User;

public interface UsersRepository {
    User getUserById(int id);
    Collection<User> getUsers();
    User getCurrentUser();
    void save(User user);
}
