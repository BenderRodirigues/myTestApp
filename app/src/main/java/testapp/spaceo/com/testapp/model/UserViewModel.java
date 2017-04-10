package testapp.spaceo.com.testapp.model;



import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;

public class UserViewModel{
    private User user;

    public final ObservableBoolean loading;
    public final ObservableBoolean active;
    public final ObservableField<String> username;

    public UserViewModel(User user) {
        this.user = user;
        username = new ObservableField<>(user.getUsername());
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
