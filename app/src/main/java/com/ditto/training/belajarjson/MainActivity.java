package com.ditto.training.belajarjson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<People> peopleArrayList;
    ArrayListAdapter arrayListAdapterku;
    ListView lvAlamat;
    public TextView tvNama, tvUmur, tvJenisKelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNama = findViewById(R.id.tv_nama);
        tvUmur = findViewById(R.id.tv_umur);
        tvJenisKelamin = findViewById(R.id.tv_jenkel);
        lvAlamat = findViewById(R.id.lv_alamat);
        peopleArrayList = new ArrayList<>();
        deserialisasiJSON();
    }

    private void deserialisasiJSON(){
        String json = loadJSONFromRaw();
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject personJO = obj.getJSONObject("person");
            String nama = personJO.getString("Name");
            String umur = personJO.getString("Age");
            String jenisKelamin = personJO.getString("Gender");

            JSONArray jsonAlamat = personJO.getJSONArray("Address");
            ArrayList<People.Alamat> alamatArrayList = new ArrayList<>();
            for(int i=0; i<jsonAlamat.length(); i++){
                JSONObject alamatJO = jsonAlamat.getJSONObject(i);
                String namaAlamat = alamatJO.getString("nameAddress");
                String detailAlamat = alamatJO.getString("detailAddress");
                String kota = alamatJO.getString("city");

                People.Alamat alamatku = new People.Alamat(namaAlamat, detailAlamat, kota);
                alamatArrayList.add(alamatku);
            }
            People people = new People(nama, umur, jenisKelamin, alamatArrayList);
            arrayListAdapterku = new ArrayListAdapter(getApplicationContext(), alamatArrayList);
            lvAlamat.setAdapter(arrayListAdapterku);
            peopleArrayList.add(people);

            tvNama.setText(nama);
            tvUmur.setText(umur);
            tvJenisKelamin.setText(jenisKelamin);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream inputStreamku = getResources().openRawResource(R.raw.people);
            int size = inputStreamku.available();
            byte[] buffer = new byte[size];
            inputStreamku.read(buffer);
            inputStreamku.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
