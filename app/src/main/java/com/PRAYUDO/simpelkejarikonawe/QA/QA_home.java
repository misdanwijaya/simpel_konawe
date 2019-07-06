package com.PRAYUDO.simpelkejarikonawe.QA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.PRAYUDO.simpelkejarikonawe.QA.konsul_hkm.form_konsul_hukum;
import com.PRAYUDO.simpelkejarikonawe.QA.penyuluhan_hukum.form_penyuluhan;
import com.PRAYUDO.simpelkejarikonawe.QA.tp4d.form_tp4d;
import com.PRAYUDO.simpelkejarikonawe.R;

public class QA_home extends AppCompatActivity {
    Button btnKonsulHkm, btntp4d, btnPenyuluhanHkm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa_home);

        btnKonsulHkm = (Button) findViewById(R.id.buttonKonsul_hkm);
        btnKonsulHkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), form_konsul_hukum.class);
                startActivity(i);
            }
        });

        btntp4d = (Button) findViewById(R.id.buttonTP4D);
        btntp4d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(),form_tp4d.class);
                startActivity(i);
            }
        });

        btnPenyuluhanHkm = (Button) findViewById(R.id.buttonPenyuluhan_hkm);
        btnPenyuluhanHkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(),form_penyuluhan.class);
                startActivity(i);
            }
        });

    }
}
