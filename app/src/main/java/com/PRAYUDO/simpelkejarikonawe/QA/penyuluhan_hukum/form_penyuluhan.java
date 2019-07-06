package com.PRAYUDO.simpelkejarikonawe.QA.penyuluhan_hukum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.PRAYUDO.simpelkejarikonawe.R;

import java.util.HashMap;

public class form_penyuluhan extends AppCompatActivity implements View.OnClickListener {
    private EditText EditNamaPemohon;
    private EditText EditAlamat;
    private EditText EditTelepon;
    private EditText EditEmail;
    private EditText EditPenyuluhan;

    private Button KlikSimpan;
    private Button KlikPenyuluhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_penyuluhan);

        EditNamaPemohon = (EditText) findViewById(R.id.EditNamaPemohon);
        EditAlamat = (EditText) findViewById(R.id.EditAlamat);
        EditTelepon = (EditText) findViewById(R.id.EditTelepon);
        EditEmail = (EditText) findViewById(R.id.EditEmail);
        EditPenyuluhan = (EditText) findViewById(R.id.EditPenyuluhan);

        KlikSimpan = (Button) findViewById(R.id.KlikSimpan);
        KlikPenyuluhan = (Button) findViewById(R.id.KlikPenyuluhan);

        KlikSimpan.setOnClickListener(this);
        KlikPenyuluhan.setOnClickListener(this);
    }

    private void addPenyuluhan(){
        final String nama_pemohon = EditNamaPemohon.getText().toString().trim();
        final String alamat = EditAlamat.getText().toString().trim();
        final String telepon = EditTelepon.getText().toString().trim();
        final String email = EditEmail.getText().toString().trim();
        final String penyuluhan = EditPenyuluhan.getText().toString().trim();

        class addPenyuluhan extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(form_penyuluhan.this, "Menambahkan...","Tunggu...", false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(form_penyuluhan.this,s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_NAMA_PEMOHON,nama_pemohon);
                params.put(konfigurasi.KEY_ALAMAT,alamat);
                params.put(konfigurasi.KEY_TELEPON,telepon);
                params.put(konfigurasi.KEY_EMAIL,email);
                params.put(konfigurasi.KEY_PERMINTAAN_PENYULUHAN_HUKUM,penyuluhan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD,params);
                return res;
            }
        }
        addPenyuluhan ap = new addPenyuluhan();
        ap.execute();
    }

    @Override
    public void onClick(View v) {
        if (v == KlikSimpan){
            addPenyuluhan();
        }
        if (v == KlikPenyuluhan){
            startActivity(new Intent(this, tampilSemuaPenyuluhan.class));
        }
    }
}
