package com.PRAYUDO.simpelkejarikonawe.QA.tp4d;

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

public class form_tp4d extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNamaInstansi;
    private EditText edtNamaKepala;
    private EditText edtAlamat;
    private EditText edtTelepon;
    private EditText edtEmail;
    private EditText edtKegiatan;
    private EditText edtNilaiKegiatan;

    private Button btnSimpan;
    private Button btnTP4D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tp4d);

        edtNamaInstansi = (EditText) findViewById(R.id.edtNamaInstansi);
        edtNamaKepala = (EditText) findViewById(R.id.edtNamaKepala);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtTelepon = (EditText) findViewById(R.id.edtTelepon);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtKegiatan = (EditText) findViewById(R.id.edtKegiatan);
        edtNilaiKegiatan = (EditText) findViewById(R.id.edtNilaiKegiatan);

        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnTP4D = (Button) findViewById(R.id.btnTP4D);

        btnSimpan.setOnClickListener(this);
        btnTP4D.setOnClickListener(this);
    }

    private void addTp4d(){
        final String nama_instansi                  = edtNamaInstansi.getText().toString().trim();
        final String nama_kepala_instansi           = edtNamaKepala.getText().toString().trim();
        final String alamat                         = edtAlamat.getText().toString().trim();
        final String telepon                        = edtTelepon.getText().toString().trim();
        final String email                          = edtEmail.getText().toString().trim();
        final String kegiatan_diminta_didampingi    = edtKegiatan.getText().toString().trim();
        final String nilai_kegiatan                 = edtNilaiKegiatan.getText().toString().trim();

        class addTp4d extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(form_tp4d.this, "Menambhkan...", "Tunggu...", false, false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(form_tp4d.this,s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_NAMA_INSTANSI, nama_instansi);
                params.put(konfigurasi.KEY_NAMA_KEPALA_INSTANSI,nama_kepala_instansi);
                params.put(konfigurasi.KEY_ALAMAT,alamat);
                params.put(konfigurasi.KEY_TELEPON,telepon);
                params.put(konfigurasi.KEY_EMAIL,email);
                params.put(konfigurasi.KEY_KEGIATAN_DIMINTA_DIDAMPINGI,kegiatan_diminta_didampingi);
                params.put(konfigurasi.KEY_NILAI_KEGIATAN,nilai_kegiatan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD,params);
                return res;
            }
        }
        addTp4d tp4d = new addTp4d();
        tp4d.execute();
    }
    @Override
    public void onClick(View v){
        if (v == btnSimpan){
            addTp4d();
        }
        if (v == btnTP4D){
            startActivity(new Intent(this, TampilSemuaTP4D.class));
        }
    }
}
