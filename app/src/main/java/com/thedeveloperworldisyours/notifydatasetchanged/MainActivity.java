package com.thedeveloperworldisyours.notifydatasetchanged;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mFragment = new MultipleFragment();
            addFragment();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_multiple:
                mFragment = MultipleFragment.newInstance();
                addFragment();
                return true;

            case R.id.menu_main_only_one:
                mFragment = OnlyOneFragment.newInstance();
                addFragment();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_content, mFragment)
                .addToBackStack(null)
                .commit();

    }
}
