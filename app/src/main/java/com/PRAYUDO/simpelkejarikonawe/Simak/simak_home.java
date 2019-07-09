package com.PRAYUDO.simpelkejarikonawe.Simak;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.PRAYUDO.simpelkejarikonawe.QA.tp4d.TampilSemuaTP4D;
import com.PRAYUDO.simpelkejarikonawe.R;

public class simak_home extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simak_home);

        button1 = (Button) findViewById(R.id.buttonPenelusuranPerkara);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://view.officeapps.live.com/op/view.aspx?src=http://simpel-konawe.000webhostapp.com/berkas/Penelusuran_Perkara.docx"));
                startActivity(browserIntent);
            }
        });

        button2 = (Button) findViewById(R.id.buttonLaporanTP4D);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), TampilSemuaTP4D.class);
                startActivity(i);
            }
        });

        button3 = (Button) findViewById(R.id.buttonKegiatan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), tampilSemuaKegiatan.class);
                startActivity(i);
            }
        });
    }
}
