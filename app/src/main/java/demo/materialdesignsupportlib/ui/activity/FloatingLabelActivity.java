package demo.materialdesignsupportlib.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import demo.materialdesignsupportlib.R;

public class FloatingLabelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_float_lab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etEmailValidation = (EditText) findViewById(R.id.etEmailValidation);
        etEmailValidation.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!TextUtils.isEmpty(etEmailValidation.getText()) &&
                            !Patterns.EMAIL_ADDRESS.matcher(etEmailValidation.getText()).matches()) {
                        etEmailValidation.setError("Invalid email address.");
                    }
                }
            }
        });
    }
}
