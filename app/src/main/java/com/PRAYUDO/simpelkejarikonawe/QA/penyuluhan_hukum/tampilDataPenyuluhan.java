package com.PRAYUDO.simpelkejarikonawe.QA.penyuluhan_hukum;

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

public class tampilDataPenyuluhan extends AppCompatActivity implements View.OnClickListener {
    private EditText EditID;
    private EditText EditNamaPemohon;
    private EditText EditAlamat;
    private EditText EditTelepon;
    private EditText EditEmail;
    private EditText EditPenyuluhan;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_penyuluhan);

        Intent intent = getIntent();
        id = intent.getStringExtra(konfigurasi.ID_PENYULUHAN);

        EditID = (EditText) findViewById(R.id.EditID);
        EditNamaPemohon = (EditText) findViewById(R.id.EditNamaPemohon);
        EditAlamat = (EditText) findViewById(R.id.EditAlamat);
        EditTelepon = (EditText) findViewById(R.id.EditTelepon);
        EditEmail = (EditText) findViewById(R.id.EditEmail);
        EditPenyuluhan = (EditText) findViewById(R.id.EditPenyuluhan);

        EditID.setText(id);
        getData();
    }

    private void getData(){
        class GetData extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilDataPenyuluhan.this, "Fetching...", "Wait...", false, false);
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
            String nama_pemohon = c.getString(konfigurasi.TAG_NAMA_PEMOHON);
            String alamat = c.getString(konfigurasi.TAG_ALAMAT);
            String telepon = c.getString(konfigurasi.TAG_TELEPON);
            String email = c.getString(konfigurasi.TAG_EMAIL);
            String permintaan_penyuluhan_hukum= c.getString(konfigurasi.TAG_PERMINTAAN_PENYULUHAN_HUKUM);

            EditNamaPemohon.setText(nama_pemohon);
            EditAlamat.setText(alamat);
            EditTelepon.setText(telepon);
            EditEmail.setText(email);
            EditPenyuluhan.setText(permintaan_penyuluhan_hukum);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
