package com.PRAYUDO.simpelkejarikonawe.QA.konsul_hkm;

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

public class form_konsul_hukum extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTextStasiunRadio;
    private EditText edtTextNama;
    private EditText edtTextJabatan;
    private EditText edtTextAlamat;
    private EditText edtTextTelepon;
    private EditText edtTextEmail;
    private EditText edtTextMateri;
    private EditText edtTextWaktuPel;

    private Button buttonSimpan;
    private Button buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_konsul_hukum);

        edtTextStasiunRadio = (EditText) findViewById(R.id.edtTextStasiunRadio);
        edtTextNama = (EditText) findViewById(R.id.edtTextNama);
        edtTextJabatan = (EditText) findViewById(R.id.edtTextJabatan);
        edtTextAlamat = (EditText) findViewById(R.id.edtTextAlamat);
        edtTextTelepon = (EditText) findViewById(R.id.edtTextTelepon);
        edtTextEmail = (EditText) findViewById(R.id.edtTextEmail);
        edtTextMateri = (EditText) findViewById(R.id.edtTextMateri);
        edtTextWaktuPel = (EditText) findViewById(R.id.edtWaktupel);

        buttonSimpan = (Button) findViewById(R.id.buttonSimpan);
        buttonDaftar  = (Button) findViewById(R.id.buttonDataKonsulHkm);

        buttonSimpan.setOnClickListener(this);
        buttonDaftar.setOnClickListener(this);
    }

    private void addKonsulHukum(){
        final String stasiun_radio = edtTextStasiunRadio.getText().toString().trim();
        final String nama = edtTextNama.getText().toString().trim();
        final String jabatan = edtTextJabatan.getText().toString().trim();
        final String alamat = edtTextAlamat.getText().toString().trim();
        final String telepon = edtTextTelepon.getText().toString().trim();
        final String email = edtTextEmail.getText().toString().trim();
        final String materi = edtTextMateri.getText().toString().trim();
        final String waktu_pelaksanaan = edtTextWaktuPel.getText().toString().trim();

        class addKonsulHukum extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(form_konsul_hukum.this, "Menambahkan...","Tunggu...", false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(form_konsul_hukum.this,s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_STASIUN_RADIO,stasiun_radio);
                params.put(konfigurasi.KEY_NAMA,nama);
                params.put(konfigurasi.KEY_JABATAN,jabatan);
                params.put(konfigurasi.KEY_ALAMAT,alamat);
                params.put(konfigurasi.KEY_TELEPON,telepon);
                params.put(konfigurasi.KEY_EMAIL,email);
                params.put(konfigurasi.KEY_MATERI,materi);
                params.put(konfigurasi.KEY_WAKTU_PELAKSANAAN,waktu_pelaksanaan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD,params);
                return res;
            }
        }
        addKonsulHukum kh = new addKonsulHukum();
        kh.execute();

        edtTextStasiunRadio.getText().clear();
        edtTextNama.getText().clear();
        edtTextJabatan.getText().clear();
        edtTextAlamat.getText().clear();
        edtTextTelepon.getText().clear();
        edtTextEmail.getText().clear();
        edtTextMateri.getText().clear();
        edtTextWaktuPel.getText().clear();
}
    @Override
    public void onClick(View v){
        if (v == buttonSimpan){

            String cek1 = edtTextStasiunRadio.getText().toString();
            String cek2 = edtTextNama.getText().toString();
            String cek3 = edtTextJabatan.getText().toString();
            String cek4 = edtTextAlamat.getText().toString();
            String cek5 = edtTextTelepon.getText().toString();
            String cek6 = edtTextEmail.getText().toString();
            String cek7 = edtTextMateri.getText().toString();
            String cek8 = edtTextWaktuPel.getText().toString();
            if (cek1.matches("")) {
                Toast.makeText(this, "Harap Masukan Nama Radio", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (cek2.matches("")) {
                Toast.makeText(this, "Harap Masukan Nama Pengaju", Toast.LENGTH_SHORT).show();
                return;
            } else if (cek3.matches("")) {
                Toast.makeText(this, "Harap Masukan Jabatan", Toast.LENGTH_SHORT).show();
                return;
            }else if (cek4.matches("")) {
                Toast.makeText(this, "Harap Masukan Alamat", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (cek5.matches("")) {
                Toast.makeText(this, "Harap Masukan Telepon", Toast.LENGTH_SHORT).show();
                return;
            } else if (cek6.matches("")) {
                Toast.makeText(this, "Harap Masukan Email", Toast.LENGTH_SHORT).show();
                return;
            } else if (cek7.matches("")) {
                Toast.makeText(this, "Harap Masukan Materi", Toast.LENGTH_SHORT).show();
                return;
            }else if (cek8.matches("")) {
                Toast.makeText(this, "Harap Masukan Waktu", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                addKonsulHukum();
            }
        }
        if (v == buttonDaftar){
            startActivity(new Intent(this,tampilsemuaData.class));
        }
    }
}
