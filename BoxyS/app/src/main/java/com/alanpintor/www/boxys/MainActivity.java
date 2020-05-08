package com.alanpintor.www.boxys;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.airhorn, 1);
        sound2 = soundPool.load(this, R.raw.coronavirusmeme, 1);
        sound3 = soundPool.load(this, R.raw.cricketsound, 1);
        sound4 = soundPool.load(this, R.raw.jokerlaugh, 1);
    }

    public void playSound(View v) {
        switch ((v.getId())) {
            case R.id.button1:
                soundPool.play(sound1,1, 1, 0, 0,1);
                break;
            case R.id.button2:
                soundPool.play(sound2,1, 1, 0, 0,1);
                break;
            case R.id.button3:
                soundPool.play(sound3,1, 1, 0, 0,1);
                break;
            case R.id.button4:
                soundPool.play(sound4,1, 1, 0, 0,1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
