package com.PRAYUDO.simpelkejarikonawe.ETilang;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.PRAYUDO.simpelkejarikonawe.R;


public class etilang_home extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etilang_home);

        button1 = (Button) findViewById(R.id.buttonCaraEtilang);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), tata_cara.class);
                startActivity(i);
            }
        });

        button2 = (Button) findViewById(R.id.buttonAlurEtilang);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), alur_tilang.class);
                startActivity(i);
            }
        });

        button3 = (Button) findViewById(R.id.buttonLaporanEtilang);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://view.officeapps.live.com/op/view.aspx?src=http://simpel-konawe.000webhostapp.com/berkas/REGISTER_TILANG.xlsx"));
                startActivity(browserIntent);
            }
        });
    }
}
