package testapp.spaceo.com.testapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import testapp.spaceo.com.testapp.BR;
import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.adapters.RecyclerBindingAdapter;
import testapp.spaceo.com.testapp.databinding.ActivityListBinding;
import testapp.spaceo.com.testapp.model.ProfileViewModel;
import testapp.spaceo.com.testapp.model.User;
import testapp.spaceo.com.testapp.repository.UsersRepository;
import testapp.spaceo.com.testapp.repository.UsersRepositoryImpl;


public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private RecyclerBindingAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        generateItems();
        initRecyclerView(binding.recyclerView);
    }

    private void generateItems() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference();
//        for (int i = 0; i < 10; i++) {
//            User user = new User("Username " + i);
//            user.setPosition("Position " + i);
//            user.setAvatarUrl("");
//            ref.child("users")
//                    .push()
//                    .setValue(user);
//        }
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerBindingAdapter<>(R.layout.item, BR.viewModel, new ArrayList<User>());
//        adapter = new ListAdapter();
        recyclerView.setAdapter(adapter);
        new UsersRepositoryImpl().getUsers(new UsersRepositoryImpl.RepositoryCallback() {
            @Override
            public void onUser(User user) {

            }

            @Override
            public void onUsers(Collection<User> userCollection) {
                adapter.addItems(userCollection);
            }
        });
    }

//    private void getItems() {
//        final LinkedList<ProfileViewModel> list = new LinkedList<>();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("users");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    list.add(new ProfileViewModel(new UsersRepository() {
//                        @Override
//                        public User getUserById(int id) {
//                            return null;
//                        }
//
//                        @Override
//                        public Collection<User> getUsers() {
//                            return null;
//                        }
//
//                        @Override
//                        public User getCurrentUser() {
//                            return snapshot.getValue(User.class);
//                        }
//
//                        @Override
//                        public void save(User user) {
//
//                        }
//                    }));
//                }
//                adapter.addItems(list);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
}
