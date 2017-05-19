package testapp.spaceo.com.testapp.repository;


import testapp.spaceo.com.testapp.model.User;

public interface UsersRepository {

    void getUsers(UsersRepositoryImpl.RepositoryCallback callback);

    void getCurrentUser(UsersRepositoryImpl.RepositoryCallback callback);

    void save(User user);
}
