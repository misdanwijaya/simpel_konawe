package com.PRAYUDO.simpelkejarikonawe.QA.konsul_hkm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.PRAYUDO.simpelkejarikonawe.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class tampilsemuaData extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_data);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void showDataAll(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i<result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID_KONSUL);
                String stasiun_radio = jo.getString(konfigurasi.TAG_STASIUN_RADIO);
//                String nama = jo.getString(konfigurasi.TAG_NAMA);
//                String jabatan = jo.getString(konfigurasi.TAG_JABATAN);
//                String alamat   = jo.getString(konfigurasi.TAG_ALAMAT);
//                String telepon = jo.getString(konfigurasi.TAG_TELEPON);
//                String email = jo.getString(konfigurasi.TAG_EMAIL);
//                String materi = jo.getString(konfigurasi.TAG_MATERI);
//                String waktu_pelaksanaan = jo.getString(konfigurasi.TAG_WAKTU_PELAKSANAAN);

                HashMap<String, String> konsulHukum = new HashMap<>();
                konsulHukum.put(konfigurasi.TAG_ID_KONSUL, id);
                konsulHukum.put(konfigurasi.TAG_STASIUN_RADIO,stasiun_radio);
//                konsulHukum.put(konfigurasi.TAG_NAMA,nama);
//                konsulHukum.put(konfigurasi.TAG_JABATAN,jabatan);
//                konsulHukum.put(konfigurasi.TAG_ALAMAT,alamat);
//                konsulHukum.put(konfigurasi.TAG_TELEPON,telepon);
//                konsulHukum.put(konfigurasi.TAG_EMAIL,email);
//                konsulHukum.put(konfigurasi.TAG_MATERI,materi);
//                konsulHukum.put(konfigurasi.TAG_WAKTU_PELAKSANAAN,waktu_pelaksanaan);
                list.add(konsulHukum);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                tampilsemuaData.this, list, R.layout.list_item,
                new String[]{konfigurasi.TAG_ID_KONSUL, konfigurasi.TAG_STASIUN_RADIO},
                new int[]{R.id.id, R.id.stasiunRadio});
        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilsemuaData.this, "Mengambil Data", "Mohon Tunggu...", false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showDataAll();
            }
            @Override
            protected String doInBackground(Void... params){
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_READ_DATA_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(this, tampilData.class);
        HashMap<String,String> map = (HashMap)parent.getItemAtPosition(position);
        String konsulID = map.get(konfigurasi.TAG_ID_KONSUL).toString();
        intent.putExtra(konfigurasi.ID_KONSUL, konsulID);
        startActivity(intent);
    }
}
