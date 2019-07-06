package com.PRAYUDO.simpelkejarikonawe.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.PRAYUDO.simpelkejarikonawe.R;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class aboutKejari extends AppCompatActivity {

    JustifiedTextView justifiedTextCiew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_about_kejari);

        justifiedTextCiew = (JustifiedTextView) findViewById(R.id.kejari);
    }
}
