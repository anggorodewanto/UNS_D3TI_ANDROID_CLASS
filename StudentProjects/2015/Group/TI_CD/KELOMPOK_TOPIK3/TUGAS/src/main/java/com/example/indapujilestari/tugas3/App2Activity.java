package com.example.indapujilestari.tugas3;
import android.app.Activity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RelativeLayout;

@SuppressLint("NewApi")
public class App2Activity extends Activity implements TabListener{

    RelativeLayout rl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        try {
            rl = (RelativeLayout) findViewById(R.id.mainLayout);
            fragMentTra = getFragmentManager().beginTransaction();
            ActionBar bar = getActionBar();
            bar.addTab(bar.newTab().setText("Listing").setTabListener(this));
            bar.addTab(bar.newTab().setText("Image").setTabListener(this));
            bar.addTab(bar.newTab().setText("Details").setTabListener(this));

            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                    | ActionBar.DISPLAY_USE_LOGO);
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            bar.setDisplayShowHomeEnabled(true);
            bar.setDisplayShowTitleEnabled(false);
            bar.show();

        } catch (Exception e) {
            e.getMessage();
        }
        /**
         * Hiding Action Bar
         */
    }

    Fragment1 fram1;
    FragmentTransaction fragMentTra = null;
    Fragment2 fram2;
    Fragment3 fram3;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {

        if (tab.getText().equals("Listing")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram1 = new Fragment1();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram1);
            fragMentTra.commit();
        } else if (tab.getText().equals("Image")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram2 = new Fragment2();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram2);
            fragMentTra.commit();
        } else if (tab.getText().equals("Details")) {
            try {
                rl.removeAllViews();
            } catch (Exception e) {
            }
            fram3 = new Fragment3();
            fragMentTra.addToBackStack(null);
            fragMentTra = getFragmentManager().beginTransaction();
            fragMentTra.add(rl.getId(), fram3);
            fragMentTra.commit();
        }

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

}