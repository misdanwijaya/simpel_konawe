package com.PRAYUDO.simpelkejarikonawe.Simak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.PRAYUDO.simpelkejarikonawe.R;

public class tampilSemuaKegiatan extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_kegiatan);
        listView = (ListView) findViewById(R.id.listViewKegiatan);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilSemuaKegiatan.this, "Mengambil Data Kegiatan", "Mohon Tunggu...", false,false);
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

    private void showDataAll(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID_KEGIATAN);
                String nama_kegiatan = jo.getString(konfigurasi.TAG_NAMA_KEGIATAN);
                String detail_kegiatan = jo.getString(konfigurasi.TAG_DETAIL_KEGIATAN);
                String waktu_kegiatan = jo.getString(konfigurasi.TAG_WAKTU_KEGIATAN);

                HashMap<String, String> kegiatan = new HashMap<>();
                kegiatan.put(konfigurasi.TAG_ID_KEGIATAN,id);
                kegiatan.put(konfigurasi.TAG_NAMA_KEGIATAN,nama_kegiatan);
                kegiatan.put(konfigurasi.TAG_DETAIL_KEGIATAN,detail_kegiatan);
                kegiatan.put(konfigurasi.TAG_WAKTU_KEGIATAN,waktu_kegiatan);
                list.add(kegiatan);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                tampilSemuaKegiatan.this, list, R.layout.list_item_kegiatan,
                new String[]{konfigurasi.TAG_WAKTU_KEGIATAN,konfigurasi.TAG_NAMA_KEGIATAN,konfigurasi.TAG_DETAIL_KEGIATAN},
                new int[]{R.id.idKegiatan, R.id.NamaKegiatan,R.id.DetailKegiatan});
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
