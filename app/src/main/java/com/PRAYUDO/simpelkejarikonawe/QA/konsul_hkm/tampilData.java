package com.PRAYUDO.simpelkejarikonawe.QA.konsul_hkm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.PRAYUDO.simpelkejarikonawe.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class tampilData extends AppCompatActivity implements View.OnClickListener {
    private EditText edtID;
    private EditText edtTextStasiunRadio;
    private EditText edtTextNama;
    private EditText edtTextJabatan;
    private EditText edtTextAlamat;
    private EditText edtTexttelepon;
    private EditText edtTextEmail;
    private EditText edtTextMateri;
    private EditText edtWaktupel;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        Intent intent = getIntent();
        id = intent.getStringExtra(konfigurasi.ID_KONSUL);

        edtID = (EditText) findViewById(R.id.edtID);
        edtTextStasiunRadio = (EditText) findViewById(R.id.edtTextStasiunRadio);
        edtTextNama = (EditText) findViewById(R.id.edtTextNama);
        edtTextJabatan = (EditText) findViewById(R.id.edtTextJabatan);
        edtTextAlamat = (EditText) findViewById(R.id.edtTextAlamat);
        edtTexttelepon = (EditText) findViewById(R.id.edtTextTelepon);
        edtTextEmail = (EditText) findViewById(R.id.edtTextEmail);
        edtTextMateri = (EditText) findViewById(R.id.edtTextMateri);
        edtWaktupel = (EditText) findViewById(R.id.edtWaktupel);

        edtID.setText(id);
        //edtTextStasiunRadio.setText(edtTextStasiunRadio);
        /*edtTextNama.setText(nama);
        edtTextJabatan.setText(jabatan);
        edtTextAlamat.setText(alamat);
        edtTexttelepon.setText(telepon);
        edtTextEmail.setText(email);
        edtTextMateri.setText(materi);
        edtWaktupel.setText(waktu_pelaksanaan);*/

        getData();
    }

    private void getData(){
        class GetData extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilData.this, "Fetching...", "Wait...", false, false);
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
            String stasiun_radio = c.getString(konfigurasi.TAG_STASIUN_RADIO);
            String nama = c.getString(konfigurasi.TAG_NAMA);
            String jabatan = c.getString(konfigurasi.TAG_JABATAN);
            String alamat = c.getString(konfigurasi.TAG_ALAMAT);
            String telepon = c.getString(konfigurasi.TAG_TELEPON);
            String email = c.getString(konfigurasi.TAG_EMAIL);
            String materi = c.getString(konfigurasi.TAG_MATERI);
            String waktu_pelaksanaan = c.getString(konfigurasi.TAG_WAKTU_PELAKSANAAN);

            edtTextStasiunRadio.setText(stasiun_radio);
            edtTextNama.setText(nama);
            edtTextJabatan.setText(jabatan);
            edtTextAlamat.setText(alamat);
            edtTexttelepon.setText(telepon);
            edtTextEmail.setText(email);
            edtTextMateri.setText(materi);
            edtWaktupel.setText(waktu_pelaksanaan);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void updatedata(){
        final String stasiun_radio = edtTextStasiunRadio.getText().toString().trim();
        final String nama = edtTextNama.getText().toString().trim();
        final String jabatan = edtTextJabatan.getText().toString().trim();
        final String alamat = edtTextAlamat.getText().toString().trim();
        final String telepon = edtTexttelepon.getText().toString().trim();
        final String email = edtTextEmail.getText().toString().trim();
        final String materi = edtTextMateri.getText().toString().trim();
        final String waktu_pelaksanaan = edtWaktupel.getText().toString().trim();

        class UpdateData extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilData.this,"Updating...","Wait...",false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(tampilData.this,s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params){
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_ID_KONSUL,id);
                hashMap.put(konfigurasi.KEY_STASIUN_RADIO,stasiun_radio);
                hashMap.put(konfigurasi.KEY_NAMA,nama);
                hashMap.put(konfigurasi.KEY_JABATAN,jabatan);
                hashMap.put(konfigurasi.KEY_ALAMAT,alamat);
                hashMap.put(konfigurasi.KEY_TELEPON,telepon);
                hashMap.put(konfigurasi.KEY_EMAIL,email);
                hashMap.put(konfigurasi.KEY_MATERI,materi);
                hashMap.put(konfigurasi.KEY_WAKTU_PELAKSANAAN,waktu_pelaksanaan);

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE,hashMap);
                return s;
            }
        }
        UpdateData ud = new UpdateData();
        ud.execute();
    }

    private void deleteData(){
        class DeleteData extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilData.this, "Updating...","Tunggu...", false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(tampilData.this, s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... params){
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE,id);
                return s;
            }
        }
        DeleteData dd = new DeleteData();
        dd.execute();
    }

    private void confirmDeleteData(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Anda Yakin Ingin Menghapus Data Ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteData();
                        startActivity(new Intent(tampilData.this, tampilsemuaData.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v){
        if (v == buttonUpdate){
            updatedata();
        }
        if (v == buttonDelete){
            confirmDeleteData();
        }
    }
}
