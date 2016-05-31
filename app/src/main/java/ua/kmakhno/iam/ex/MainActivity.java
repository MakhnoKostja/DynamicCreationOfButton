package ua.kmakhno.iam.ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout llMain;
    private EditText eText;
    private Button create;
    private Button clear;
    private RadioGroup rgView;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout)findViewById(R.id.llMain);
        eText = (EditText)findViewById(R.id.editText);
        create = (Button)findViewById(R.id.create);
        create.setOnClickListener(this);

        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);

        rgView = (RadioGroup)findViewById(R.id.rgGravity);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
                int btnGravity = Gravity.LEFT;
                switch (rgView.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                layoutParams.gravity = btnGravity;

                Button btnNew = new Button(this);
                btnNew.setText(eText.getText().toString());
                llMain.addView(btnNew, layoutParams);
                break;
            case R.id.clear:
                llMain.removeAllViews();
                Toast.makeText(this, "All remove", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
