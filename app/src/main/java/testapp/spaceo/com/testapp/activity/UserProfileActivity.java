package testapp.spaceo.com.testapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.fragments.UserProfileFragment;


public class UserProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, UserProfileFragment.newInstance(), null)
                .commit();
    }
}
