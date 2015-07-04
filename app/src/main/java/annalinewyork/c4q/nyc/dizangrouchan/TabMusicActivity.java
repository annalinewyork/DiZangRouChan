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

    private ProgressBar progressBar;
    private Handler handler = new Handler();
    int progress = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ImageButton buttonStart = (ImageButton)findViewById(R.id.buttonStart);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (!playing) {
                    playing = true;
                    buttonStart.setImageResource(R.drawable.media_stop2);
                    Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.bashibafo);

                    if (mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(TabMusicActivity.this, path);
                    }
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                        process();
                    }
                }
                else {
                    playing = false;
                    buttonStart.setImageResource(R.drawable.media_play2);

                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();

                    }
                }

            }
        });

//        ImageButton buttonStop = (ImageButton)findViewById(R.id.buttonStop);
//        buttonStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();
//                   // mediaPlayer.release();
//                }else{
//                    mediaPlayer.start();
//                }
//            }
//        });

        ImageButton buttonLoop = (ImageButton)findViewById(R.id.buttonLoop);
        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    private void process (){
        progressBar.setProgress(0);

        progress = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100){
                    progress = doWork();
                    try{
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post( new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                        }
                    });
                }
            }
        }).start();
    }

    private int doWork(){
        progress++;
        if (progress < 100){
            return progress;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
