package g.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //constants
    private static final String TAG = SplashScreen.class.getSimpleName();
    private static final int T_DATA = 3000;

    //widgets
    private ImageView logotype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screeen);

        init();
    }

    private void init() {
        logotype = findViewById(R.id.logotype);
        logotype.setAnimation(animationLogotype());
        goToDashboard();
    }

    private void goToDashboard() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: Sending to Dashboard");
                startActivity(new Intent(SplashScreen.this, Dashboard.class));
            }
        }, T_DATA);
    }

    private AnimationSet animationLogotype() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(2000);

        Animation scale = new ScaleAnimation(
                0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setFillAfter(true);
        scale.setDuration(1300);

        AnimationSet manageAnim = new AnimationSet(false);
        manageAnim.addAnimation(scale);
        manageAnim.addAnimation(fadeIn);

        return manageAnim;
    }
}
