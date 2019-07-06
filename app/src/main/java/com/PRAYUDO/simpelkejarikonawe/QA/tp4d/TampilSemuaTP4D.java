package com.PRAYUDO.simpelkejarikonawe.QA.tp4d;

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

public class TampilSemuaTP4D extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_tp4d);
        listView = (ListView) findViewById(R.id.listViewTP4D);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void showDataAll(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID_TP4D);
                String nama_instansi = jo.getString(konfigurasi.TAG_NAMA_INSTANSI);

                HashMap<String, String> tp4d = new HashMap<>();
                tp4d.put(konfigurasi.TAG_ID_TP4D,id);
                tp4d.put(konfigurasi.TAG_NAMA_INSTANSI,nama_instansi);
                list.add(tp4d);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                TampilSemuaTP4D.this, list, R.layout.list_item_tp4d,
                new String[]{konfigurasi.TAG_ID_TP4D, konfigurasi.TAG_NAMA_INSTANSI},
                new int[]{R.id.idTP4D, R.id.namaInstansi});
                listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(TampilSemuaTP4D.this, "Mengambil Data", "Mohon Tunggu...", false,false);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TampilDataTP4D.class);
        HashMap<String,String> map = (HashMap)parent.getItemAtPosition(position);
        String TP4Did = map.get(konfigurasi.TAG_ID_TP4D).toString();
        intent.putExtra(konfigurasi.TAG_ID_TP4D, TP4Did);
        startActivity(intent);
    }
}
