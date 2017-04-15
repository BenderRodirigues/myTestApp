package testapp.spaceo.com.testapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.databinding.ActivityConstraintAnimBinding;


public class ConstraintAnimationsActivity extends AppCompatActivity {
    private ActivityConstraintAnimBinding binding;

    private ConstraintSet setCollapsed = new ConstraintSet();
    private ConstraintSet setExpanded = new ConstraintSet();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_constraint_anim);
        setCollapsed.clone(binding.mainConstraint);
        setExpanded.clone(this, R.layout.activity_constraint_anim_expanded);
        binding.showextended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFull(true);
            }
        });
        binding.hideextended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFull(false);
            }
        });
    }

    private void showFull(boolean extended) {
        TransitionManager.beginDelayedTransition(binding.mainConstraint);
        if(extended) {
            setExpanded.applyTo(binding.mainConstraint);
        } else {
            setCollapsed.applyTo(binding.mainConstraint);
        }
    }
}