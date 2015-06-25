package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by c4q-nali on 6/21/15.
 */
public class TabContentActivity extends Activity {
    TextView contentText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content);
        contentText = (TextView)findViewById(R.id.contentText);
        contentText.setMovementMethod(new ScrollingMovementMethod());
    }
}
