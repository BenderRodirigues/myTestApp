package testapp.spaceo.com.testapp.model;



import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collection;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.app.App;
import testapp.spaceo.com.testapp.repository.UsersRepository;
import testapp.spaceo.com.testapp.repository.UsersRepositoryImpl;
import testapp.spaceo.com.testapp.utils.CircleTransform;

public class ProfileViewModel implements UsersRepositoryImpl.RepositoryCallback {
    private final UsersRepository repository;
    private User user;

    private static final String TAG = "ProfileViewModel";

    public final ObservableBoolean loading = new ObservableBoolean();
    public final ObservableBoolean active = new ObservableBoolean();
    public final ObservableField<String> avatar = new ObservableField<>();
    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<String> position = new ObservableField<>();
    public final ObservableField<String> skills = new ObservableField<>();

    @BindingAdapter("binding:imageUrl")
    public static void setImage(ImageView view, String url) {
        Picasso.with(App.getApp().getApplicationContext())
                .load(url)
                .resize(300, 300)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .transform(new CircleTransform())
                .into(view);
    }

    public ProfileViewModel() {
        this.repository = new UsersRepositoryImpl();
        repository.getCurrentUser(this);
        initUser();
    }

    private void initUser() {
        avatar.set(user.getAvatarUrl());
        username.set(user.getUsername());
        position.set(user.getPosition());
        skills.set(user.getSkills());
        username.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                String changedUsername = username.get();
                user.setUsername(changedUsername);
            }
        });
    }


    public void setUsername(String username) {
        Log.d(TAG, "setUsername() called with: username = [" + username + "]");
        this.user.setUsername(username);
        this.username.set(username);
        repository.save(user);
    }

    public void setActive(boolean active) {
        this.user.setPrivateAccount(active);
        this.active.set(active);
        repository.save(user);
    }

    public void setPosition(String position) {
        this.position.set(position);
        user.setPosition(position);
        repository.save(user);
    }

    public void setSkills(String skills) {
        this.skills.set(skills);
        user.setSkills(skills);
        repository.save(user);
    }

    public void setLoading(boolean loading) {
        this.loading.set(loading);
    }

    public void changeStatus() {
        loadEmulation();
    }

    private void loadEmulation() {
        setLoading(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setLoading(false);
            }
        }, 1000);
    }


    @Override
    public void onUser(User user) {
        this.user = user;
    }

    @Override
    public void onUsers(Collection<User> userCollection) {

    }
}
