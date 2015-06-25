package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends TabActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = getTabHost();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("tabMusic");
        spec1.setContent(new Intent(this, TabMusicActivity.class));
        spec1.setIndicator("音 乐");
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("tabContent");
        spec2.setContent(new Intent(this, TabContentActivity.class));
        spec2.setIndicator("经 文");
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tabExplanation");
        spec3.setContent(new Intent(this, TabExplanationActivity.class));
        spec3.setIndicator("说 明");
        tabHost.addTab(spec3);
    }
}
