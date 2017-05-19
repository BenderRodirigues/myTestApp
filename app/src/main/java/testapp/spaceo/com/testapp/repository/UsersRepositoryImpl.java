package testapp.spaceo.com.testapp.repository;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import testapp.spaceo.com.testapp.model.User;

public class UsersRepositoryImpl implements UsersRepository {

    @Override
    public void getUsers(RepositoryCallback callback) {
        getItems(callback);
    }

    @Override
    public void getCurrentUser(RepositoryCallback callback) {
        callback.onUser(new User("Ivan Petrov"));
    }

    @Override
    public void save(User user) {

    }

    private void getItems(final RepositoryCallback callback) {
        final List<User> list = new LinkedList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    list.add(snapshot.getValue(User.class));
                    callback.onUsers(list);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public interface RepositoryCallback {
        void onUser(User user);
        void onUsers(Collection<User> userCollection);
    }
}
