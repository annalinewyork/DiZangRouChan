package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by c4q-nali on 6/21/15.
 */
public class TabExplanationActivity extends Activity {

    TextView explanationText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_explanation);
        explanationText = (TextView)findViewById(R.id.explanationText);
        explanationText.setMovementMethod(new ScrollingMovementMethod());
    }
}
