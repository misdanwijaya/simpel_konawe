package com.PRAYUDO.simpelkejarikonawe.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.PRAYUDO.simpelkejarikonawe.R;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class doktrin extends AppCompatActivity {
    JustifiedTextView justifiedTextViewDoktrin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_doktrin);

        justifiedTextViewDoktrin = (JustifiedTextView) findViewById(R.id.doktrin);
    }
}
