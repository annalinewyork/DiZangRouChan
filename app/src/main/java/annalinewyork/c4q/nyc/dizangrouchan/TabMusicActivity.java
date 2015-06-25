package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TabMusicActivity extends Activity {
    MediaPlayer mediaPlayer;
//    ProgressBar progressBar;
//    Handler handler;
//
//    private static final int PROGRESS = 0x1;
//    private int mProgressStatus = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ImageButton buttonStart = (ImageButton)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.bashibafo);
                mediaPlayer = MediaPlayer.create(TabMusicActivity.this, path);
                mediaPlayer.start();
            }
        });

        ImageButton buttonStop = (ImageButton)findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                   // mediaPlayer.release();
                }else{
                    mediaPlayer.start();
                }
            }
        });

        ImageButton buttonLoop = (ImageButton)findViewById(R.id.buttonLoop);
        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setLooping(true);
            }
        });

//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        handler = new Handler();
//
//        // Start lengthy operation in a BACKGROUND thread
//        new Thread(new Runnable() {
//            public void run() {
//                while (mProgressStatus < 100) {
//                    mProgressStatus = doWork();
//
//                    // UPDATE the progress bar
//                    mHandler.post(new Runnable() {
//                        public void run() {
//                            progressBar.setProgress(mProgressStatus);
//                        }
//                    });
//                }
//            }
//        }).start();
 //   }



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
