package testapp.spaceo.com.testapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.LinkedList;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.adapters.ListAdapter;
import testapp.spaceo.com.testapp.databinding.ActivityListBinding;
import testapp.spaceo.com.testapp.model.ListItem;
import testapp.spaceo.com.testapp.model.User;


public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;

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
        ListAdapter adapter = new ListAdapter();
        adapter.addItems(getItems());
        recyclerView.setAdapter(adapter);
    }

    private Collection<ListItem> getItems() {
        LinkedList<ListItem> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ListItem(String.format("Title %d", i+1), "Some description"));
        }


        list.addAll(list);
        return list;
    }
}
