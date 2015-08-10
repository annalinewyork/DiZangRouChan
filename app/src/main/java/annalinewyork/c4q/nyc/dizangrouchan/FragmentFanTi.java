package annalinewyork.c4q.nyc.dizangrouchan;


import android.os.Bundle;
import android.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import annalinewyork.c4q.nyc.dizangrouchan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFanTi extends Fragment {

    TextView contentText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_fragment_fanti, container, false);

        contentText = (TextView) fragmentView.findViewById(R.id.contentText);
        contentText.setMovementMethod(new ScrollingMovementMethod());

        return fragmentView;
    }


}
