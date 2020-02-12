package com.ditto.training.belajarjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayListAdapter extends ArrayAdapter<People.Alamat> {


    public ArrayListAdapter(@NonNull Context context, ArrayList<People.Alamat> arrayListku) {
        super(context, 0, arrayListku);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        People.Alamat alamatku = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listview, parent, false);
        TextView tvNamaAlamat = convertView.findViewById(R.id.tv_nama_alamat);
        TextView tvDetailAlamat = convertView.findViewById(R.id.tv_detail_alamat);
        TextView tvKota = convertView.findViewById(R.id.tv_kota);

        tvNamaAlamat.setText(alamatku.getNameAddres());
        tvDetailAlamat.setText(alamatku.getDetailAddress());
        tvKota.setText(alamatku.getCit());

        return convertView;
    }
}
