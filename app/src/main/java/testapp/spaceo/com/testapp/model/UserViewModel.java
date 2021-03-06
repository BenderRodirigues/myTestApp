package testapp.spaceo.com.testapp.model;



import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.app.App;
import testapp.spaceo.com.testapp.utils.CircleTransform;

public class UserViewModel{
    private User user;

    public final ObservableBoolean loading;
    public final ObservableBoolean active;
    public final ObservableField<String> avatar;
    public final ObservableField<String> username;
    public final ObservableField<String> position;
    public final ObservableField<String> skills;

    @BindingAdapter("binding:imageUrl")
    public static void setImage(ImageView view, String url) {
        Picasso.with(App.getApp().getApplicationContext())
                .load(url)
                .resize(300, 300)
                .centerCrop()
                .placeholder(R.drawable.ic_android)
                .transform(new CircleTransform())
                .into(view);
    }

    public UserViewModel(User user) {
        this.user = user;
        avatar = new ObservableField<>(user.getAvatarUrl());
        username = new ObservableField<>(user.getUsername());
        position = new ObservableField<>(user.getPosition());
        skills = new ObservableField<>(user.getSkills());
        loading = new ObservableBoolean(false);
        active = new ObservableBoolean(user.isPrivateAccount());
    }


    public void setUsername(String username) {
        this.user.setUsername(username);
        this.username.set(username);
    }

    public void setActive(boolean active) {
        this.user.setPrivateAccount(active);
        this.active.set(active);
    }

    public void setPosition(String position) {
        this.position.set(position);
        user.setPosition(position);
    }

    public void setSkills(String skills) {
        this.skills.set(skills);
        user.setSkills(skills);
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


}
