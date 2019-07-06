package com.PRAYUDO.simpelkejarikonawe.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.PRAYUDO.simpelkejarikonawe.R;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class Visi_Misi extends AppCompatActivity {

    JustifiedTextView justifiedKejari;
    JustifiedTextView justifiedVisi;
    JustifiedTextView justifiedMisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_visi_misi);

        justifiedKejari = (JustifiedTextView) findViewById(R.id.kejari);
        justifiedMisi = (JustifiedTextView) findViewById(R.id.visi);
        justifiedVisi = (JustifiedTextView) findViewById(R.id.misi);
    }
}
