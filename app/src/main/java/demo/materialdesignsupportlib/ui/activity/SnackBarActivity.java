package demo.materialdesignsupportlib.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import demo.materialdesignsupportlib.R;

public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_snackbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showSimpleSnackbar(View view) {
        Snackbar.make(view, R.string.snackbar_snackbar_simple_text, Snackbar.LENGTH_LONG)
                .show();
    }

    public void showActionSnackbar(View view) {
        Snackbar.make(view, R.string.snackbar_snackbar_action_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_snackbar_action_action_text, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), R.string.snackbar_snackbar_action_toast_text, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
}
