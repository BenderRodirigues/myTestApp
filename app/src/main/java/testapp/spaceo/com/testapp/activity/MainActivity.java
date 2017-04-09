package testapp.spaceo.com.testapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import testapp.spaceo.com.testapp.R;
import testapp.spaceo.com.testapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Animation animation;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
        binding.openList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openList();
            }
        });
        animation = AnimationUtils.loadAnimation(this, R.anim.test);
        binding.textView.setVisibility(View.INVISIBLE);
        float value = getResources().getDimension(R.dimen.button_translation) * -1;
        binding.button.animate()
                .translationXBy(value)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(300)
                .start();
        binding.cardView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.card_view_slide));
        binding.openProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
            }
        });
    }

    private void openList() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    private void startAnimation() {
        binding.textView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
