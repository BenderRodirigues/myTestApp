package testapp.spaceo.com.testapp.repository;


import java.util.Collection;

import testapp.spaceo.com.testapp.model.User;

public class UsersRepositoryImpl implements UsersRepository {
    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return new User("test");
    }

    @Override
    public void save(User user) {

    }
}
