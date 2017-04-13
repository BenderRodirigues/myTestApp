package testapp.spaceo.com.testapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Collection;
import java.util.LinkedList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.adapters.ListAdapter;
import testapp.spaceo.com.testapp.databinding.ActivityListBinding;
import testapp.spaceo.com.testapp.model.ListItem;


public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(42)
                .build();
        realm = Realm.getInstance(config);
        RealmResults<ListItem> result = realm.where(ListItem.class).findAll();
        if(result.size() == 0) {
            generateItems();
        }
        initRecyclerView(binding.recyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private void generateItems() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < 30; i++) {
                    ListItem listItem = realm.createObject(ListItem.class);
                    listItem.setTitle("Title " + i+1);
                    listItem.setDescription("Descripton " + i+1);
                }
            }
        });
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
//        for (int i = 0; i < 20; i++) {
//            list.add(new ListItem(String.format("Title %d", i+1), "Some description"));
//        }
        RealmResults<ListItem> result = realm.where(ListItem.class).findAll();

        list.addAll(result);
        return list;
    }
}
