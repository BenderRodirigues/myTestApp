package testapp.spaceo.com.testapp.app;

import android.app.Application;

import com.facebook.stetho.Stetho;


public class App extends Application {

    private static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        app = this;
    }

    public static Application getApp() {
        return app;
    }
}
