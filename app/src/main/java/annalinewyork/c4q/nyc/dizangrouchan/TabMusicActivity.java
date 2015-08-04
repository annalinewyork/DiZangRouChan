package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TabMusicActivity extends Activity {
    MediaPlayer mediaPlayer;
    private boolean playing = false;
    private boolean looping = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ImageButton buttonStart = (ImageButton) findViewById(R.id.playButton);
        Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bashibafo);

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(TabMusicActivity.this, path);
        }

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!playing) {
                    playing = true;
                    buttonStart.setImageResource(R.drawable.btn_pause);

                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                    }
                } else {
                    playing = false;
                    buttonStart.setImageResource(R.drawable.btn_play);

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();

                    }
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                buttonStart.setImageResource(R.drawable.btn_play);
            }
        });


        final ImageButton buttonLoop = (ImageButton) findViewById(R.id.loopButton);
        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!looping) {
                    looping = true;
                    buttonLoop.setImageResource(R.drawable.btn_loop_run_pressed);
                    mediaPlayer.setLooping(true);
                } else {
                    looping = false;
                    buttonLoop.setImageResource(R.drawable.btn_loop_run_defult);
                    mediaPlayer.setLooping(false);
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
