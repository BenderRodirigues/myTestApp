package testapp.spaceo.com.testapp.model;



import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;

public class UserViewModel{
    private User user;

    public final ObservableBoolean loading;
    public final ObservableField<String> username;

    public UserViewModel(User user) {
        this.user = user;
        username = new ObservableField<>(user.getUsername());
        loading = new ObservableBoolean(false);
    }


    public void setUsername(String username) {
        this.user.setUsername(username);
        this.username.set(username);
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
