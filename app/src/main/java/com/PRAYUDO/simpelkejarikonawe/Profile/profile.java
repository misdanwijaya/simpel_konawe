package com.PRAYUDO.simpelkejarikonawe.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.PRAYUDO.simpelkejarikonawe.R;

public class profile extends AppCompatActivity {

    Button btnKejari, btnVisiMisi, btnDoktrin, btnStruktur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnKejari = (Button) findViewById(R.id.buttonKejaksaaanRI);
        btnKejari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), aboutKejari.class);
                startActivity(i);
            }
        });

        btnVisiMisi = (Button) findViewById(R.id.buttonVisiMisi);
        btnVisiMisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Visi_Misi.class);
                startActivity(i);
            }
        });

        btnDoktrin = (Button) findViewById(R.id.buttonDoktrinKejaksaan);
        btnDoktrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), doktrin.class);
                startActivity(i);
            }
        });

        btnStruktur = (Button) findViewById(R.id.buttonStrukturOrganisasi);
        btnStruktur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), strukturOrganisasi.class);
                startActivity(i);
            }
        });
    }
}
