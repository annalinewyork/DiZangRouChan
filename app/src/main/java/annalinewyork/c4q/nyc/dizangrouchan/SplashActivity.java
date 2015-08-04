package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.util.logging.LogRecord;


public class SplashActivity extends Activity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Runnable startMainMethodRunnale = new Runnable() {
            @Override
            public void run() {
                startMain();
            }
        };

        handler = new Handler();
        handler.postDelayed(startMainMethodRunnale, 2000);

    }

    protected void startMain() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

    }
}