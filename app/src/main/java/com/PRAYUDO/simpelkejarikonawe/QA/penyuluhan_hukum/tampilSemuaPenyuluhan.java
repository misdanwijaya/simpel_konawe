package com.PRAYUDO.simpelkejarikonawe.QA.penyuluhan_hukum;

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

public class tampilSemuaPenyuluhan extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_penyuluhan);
        listView = (ListView) findViewById(R.id.listViewPenyuluhan);
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
                String id = jo.getString(konfigurasi.TAG_ID_PENYULUHAN);
                String nama_pemohon = jo.getString(konfigurasi.TAG_NAMA_PEMOHON);

                HashMap<String, String> penyuluhan = new HashMap<>();
                penyuluhan.put(konfigurasi.TAG_ID_PENYULUHAN,id);
                penyuluhan.put(konfigurasi.TAG_NAMA_PEMOHON,nama_pemohon);
                list.add(penyuluhan);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                tampilSemuaPenyuluhan.this, list, R.layout.list_item_penyuluhan,
                new String[]{konfigurasi.ID_PENYULUHAN, konfigurasi.TAG_NAMA_PEMOHON},
                new int[]{R.id.idPenyuluhan, R.id.NamaPemohon});
        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(tampilSemuaPenyuluhan.this, "Mengambil Data", "Mohon Tunggu...", false,false);
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
        Intent intent = new Intent(this, tampilDataPenyuluhan.class);
        HashMap<String,String> map = (HashMap)parent.getItemAtPosition(position);
        String PenyuluhanID = map.get(konfigurasi.TAG_ID_PENYULUHAN).toString();
        intent.putExtra(konfigurasi.TAG_ID_PENYULUHAN,PenyuluhanID);
        startActivity(intent);
    }
}
