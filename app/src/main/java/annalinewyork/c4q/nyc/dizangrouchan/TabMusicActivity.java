package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;


import java.util.logging.LogRecord;

public class TabMusicActivity extends Activity {
    MediaPlayer mediaPlayer;
    private boolean playing = false;
    private boolean looping = false;


    private Handler handler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ImageButton buttonStart = (ImageButton) findViewById(R.id.playButton);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!playing) {
                    playing = true;
                    buttonStart.setImageResource(R.drawable.button_stop);
                    Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bashibafo);

                    if (mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(TabMusicActivity.this, path);
                    }
                    if (mediaPlayer != null) {
                        mediaPlayer.start();

                    }
                } else {
                    playing = false;
                    buttonStart.setImageResource(R.drawable.button_play);

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();

                    }
                }
            }
        });


        final ImageButton buttonLoop = (ImageButton) findViewById(R.id.loopButton);
        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mediaPlayer.setLooping(true);

                if (playing) {
                    if (!looping) {
                        looping = true;
                        buttonLoop.setImageResource(R.drawable.button_loop_pressed);
                        mediaPlayer.setLooping(true);
                    } else {
                        looping = false;
                        buttonLoop.setImageResource(R.drawable.button_loop_default);
                        mediaPlayer.setLooping(false);
                    }
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
