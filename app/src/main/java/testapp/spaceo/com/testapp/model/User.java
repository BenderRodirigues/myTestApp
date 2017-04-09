package testapp.spaceo.com.testapp.model;


import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.view.View;

public class User {
    public final ObservableField<String> username = new ObservableField<>("");
    public final ObservableBoolean active = new ObservableBoolean(false);
    public final ObservableBoolean loading = new ObservableBoolean(false);

    public User(String username) {
        this.username.set(username);
    }

    @BindingAdapter("app:onClick")
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
            }
        });
    }

    public String getUserneme() {
        return username.get();
    }

    public void changeStatus() {
        loadEmulation();
    }

    private void loadEmulation() {
        loading.set(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                active.set(!active.get());
                loading.set(false);
            }
        }, 1000);
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }
}
