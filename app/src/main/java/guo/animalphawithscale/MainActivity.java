package guo.animalphawithscale;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private View view1,view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = this.findViewById(R.id.view1);
        view2 = this.findViewById(R.id.view2);

        startAnim(view1);
        Timer timer = new Timer();
        timer.schedule(task,400);

    }


    private void startAnim(View view){
        ObjectAnimator animAlpha = ObjectAnimator.ofFloat(view, "alpha", 0.8f, 0f);
        animAlpha.setRepeatMode(ValueAnimator.RESTART);
        animAlpha.setRepeatCount(100);
        ObjectAnimator animScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f);
        animScaleX.setRepeatMode(ValueAnimator.RESTART);
        animScaleX.setRepeatCount(100);
        ObjectAnimator animScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f);
        animScaleY.setRepeatMode(ValueAnimator.RESTART);
        animScaleY.setRepeatCount(100);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animAlpha).with(animScaleX).with(animScaleY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startAnim(view2);
                }
            });

        }
    };

}
