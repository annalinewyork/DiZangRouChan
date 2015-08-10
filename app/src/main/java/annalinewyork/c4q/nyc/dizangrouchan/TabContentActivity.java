package annalinewyork.c4q.nyc.dizangrouchan;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;


public class TabContentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content);
    }

    public void switchFragment(View view) {

        if (view == findViewById(R.id.jianti)) {

            String fragmentTagKey = getResources().getString(R.string.fragment_tag_jianti);
            FragmentManager fm = getFragmentManager();
            FragmentJianTi fragmentJianTi = (FragmentJianTi) fm.findFragmentByTag(fragmentTagKey);
            if (fragmentJianTi == null) {
                fragmentJianTi = new FragmentJianTi();
            }
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.contentText, fragmentJianTi, fragmentTagKey);
            ft.addToBackStack(fragmentTagKey);
            ft.commit();

        } else if (view == findViewById(R.id.fanti)) {
            String fragmentTagKey = getResources().getString(R.string.fragment_tag_fanti);
            FragmentManager fm = getFragmentManager();
            FragmentFanTi fragmentFanTi = (FragmentFanTi) fm.findFragmentByTag(fragmentTagKey);
            if (fragmentFanTi == null) {
                fragmentFanTi = new FragmentFanTi();
            }

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.contentText, fragmentFanTi, fragmentTagKey);
            ft.addToBackStack(fragmentTagKey);
            ft.commit();
        }
    }
}
