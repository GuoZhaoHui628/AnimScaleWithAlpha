package guo.animalphawithscale;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 =  this.findViewById(R.id.view1);
        ObjectAnimator animAlpha = ObjectAnimator.ofFloat(view1, "alpha", 0.8f, 0.6f,0f);
        animAlpha.setRepeatMode(ValueAnimator.RESTART);
        animAlpha.setRepeatCount(100);
        ObjectAnimator animScaleX = ObjectAnimator.ofFloat(view1, "scaleX", 1f, 1.4f,1.6f);
        animScaleX.setRepeatMode(ValueAnimator.RESTART);
        animScaleX.setRepeatCount(100);
        ObjectAnimator animScaleY = ObjectAnimator.ofFloat(view1, "scaleY", 1f, 1.4f,1.6f);
        animScaleY.setRepeatMode(ValueAnimator.RESTART);
        animScaleY.setRepeatCount(100);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animAlpha).with(animScaleX).with(animScaleY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
