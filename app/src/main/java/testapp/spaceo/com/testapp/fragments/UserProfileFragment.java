package testapp.spaceo.com.testapp.fragments;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.databinding.FragmentUserProfileBinding;
import testapp.spaceo.com.testapp.model.User;
import testapp.spaceo.com.testapp.model.UserViewModel;


public class UserProfileFragment extends Fragment {
    private UserViewModel userViewModel;
    
    public static UserProfileFragment newInstance() {

        Bundle args = new Bundle();

        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentUserProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        User user = new User("Some user name");
        userViewModel = new UserViewModel(user);
        binding.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.changeStatus();
            }
        });
        binding.setViewModel(userViewModel);
        return binding.getRoot();
    }

}
