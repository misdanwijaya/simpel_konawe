package com.PRAYUDO.simpelkejarikonawe.QA.tp4d;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.PRAYUDO.simpelkejarikonawe.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TampilDataTP4D extends AppCompatActivity implements View.OnClickListener {
    private EditText edtID;
    private EditText edtNamaInstansi;
    private EditText edtNamaKepala;
    private EditText edtAlamat;
    private EditText edtTelepon;
    private EditText edtEmail;
    private EditText edtKegiatan;
    private EditText edtNilaiKegiatan;

    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_tp4d);

        Intent intent = getIntent();
        id = intent.getStringExtra(konfigurasi.ID_TP4D);

        edtID = (EditText) findViewById(R.id.edtID);
        edtNamaInstansi = (EditText) findViewById(R.id.edtNamaInstansi);
        edtNamaKepala = (EditText) findViewById(R.id.edtNamaKepala);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtTelepon = (EditText) findViewById(R.id.edtTelepon);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtKegiatan = (EditText) findViewById(R.id.edtKegiatan);
        edtNilaiKegiatan = (EditText) findViewById(R.id.edtNilaiKegiatan);

        edtID.setText(id);
        getData();
    }

    private void getData(){
        class GetData extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(TampilDataTP4D.this, "Fetching...", "Wait...", false, false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                showData(s);
            }
            @Override
            protected String doInBackground(Void... params){
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_READ_DATA,id);
                return s;
            }
        }
        GetData gd = new GetData();
        gd.execute();
    }

    private void showData(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nama_instansi = c.getString(konfigurasi.TAG_NAMA_INSTANSI);
            String nama_kepala_instansi = c.getString(konfigurasi.TAG_NAMA_KEPALA_INSTANSI);
            String alamat = c.getString(konfigurasi.TAG_ALAMAT);
            String telepon = c.getString(konfigurasi.TAG_TELEPON);
            String email = c.getString(konfigurasi.TAG_EMAIL);
            String kegiatan_diminta_didampingi = c.getString(konfigurasi.TAG_KEGIATAN_DIMINTA_DIDAMPINGI);
            String nilai_kegiatan = c.getString(konfigurasi.TAG_NILAI_KEGIATAN);

            edtNamaInstansi.setText(nama_instansi);
            edtNamaKepala.setText(nama_kepala_instansi);
            edtAlamat.setText(alamat);
            edtTelepon.setText(telepon);
            edtEmail.setText(email);
            edtKegiatan.setText(kegiatan_diminta_didampingi);
            edtNilaiKegiatan.setText(nilai_kegiatan);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
