package testapp.spaceo.com.testapp.app;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class App extends Application {

    private static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("users");
        scoresRef.keepSynced(true);
        app = this;
    }

    public static Application getApp() {
        return app;
    }
}
