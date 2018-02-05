package com.dnerd.dipty.crystalBall;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MagicBall mMagicBall = new MagicBall();
    private TextView mAnswerLabel;
    private ImageView mCrystalBallImage;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDitector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning the the view from layout file
         mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDitector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                handleNewAnswer();
            }
        });

        /*istead of giving a value I've used a constant, constatnt like this prove a consistant user experience
            because user expects toast and other things to work the same way across the apps
            so, using constants that are same for all app is better than having every app code its own value
         */
       // Toast.makeText(this,"Yay! our activity was created",Toast.LENGTH_LONG).show();


    }
    /*
        these two methods are part of the baseActivity Class just like oncreate method
        and just like it these methods orverrides the definition that exists in activity class
        that's why we have this special @override annotation
     */
    @Override
    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(mShakeDitector,mAccelerometer,
                SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mShakeDitector);
    }

    private void handleNewAnswer() {
        String answer = mMagicBall.getAnAnswer();
        //update the label with our dynamic answer
        mAnswerLabel.setText(answer);

        animateCrytalBall();
        animateAnswer();
        playSound();
    }

    private void animateCrytalBall(){
        mCrystalBallImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
        if(ballAnimation.isRunning())
        {
            ballAnimation.stop();
        }
        ballAnimation.start();
    }

    private void animateAnswer(){
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
        fadeInAnimation.setDuration(1500);
        fadeInAnimation.setFillAfter(true);

        mAnswerLabel.setAnimation(fadeInAnimation);
    }

    private void playSound(){
        MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
}
