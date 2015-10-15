package demo.materialdesignsupportlib.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import demo.materialdesignsupportlib.R;

public class FABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onFABClick(View v) {
        Toast.makeText(getApplicationContext(), R.string.fab_fab_toast_text, Toast.LENGTH_SHORT).show();
    }

    public void onMiniFABClick(View v) {
        Toast.makeText(getApplicationContext(), R.string.fab_minifab_toast_text, Toast.LENGTH_SHORT).show();
    }
}
