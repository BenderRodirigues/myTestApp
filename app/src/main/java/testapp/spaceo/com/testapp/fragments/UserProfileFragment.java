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
import testapp.spaceo.com.testapp.model.ProfileViewModel;
import testapp.spaceo.com.testapp.repository.UsersRepository;
import testapp.spaceo.com.testapp.repository.UsersRepositoryImpl;


public class UserProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;
    
    public static UserProfileFragment newInstance() {

        Bundle args = new Bundle();

        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentUserProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        profileViewModel = new ProfileViewModel();
        binding.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileViewModel.changeStatus();
            }
        });
        binding.setViewModel(profileViewModel);
        return binding.getRoot();
    }

}
