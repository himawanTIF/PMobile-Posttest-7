package com.android.post7_1700018032;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EksplisitActivity extends Fragment {
    private EditText rjari_jari, ttinggi, sselimut;
    private Button hBtn_hvolume, hBtn_hluas;
    private TextView hasil_volume, hasil_luaspm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Eksplisit = inflater.inflate(R.layout.activity_eksplisit, container, false);

        return Eksplisit;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rjari_jari = (EditText) view.findViewById(R.id.jari_jari);
        ttinggi = (EditText) view.findViewById(R.id.tinggi);
        sselimut = (EditText) view.findViewById(R.id.selimut);
        hBtn_hvolume = (Button) view.findViewById(R.id.btn_htvolume);
        hBtn_hluas = (Button) view.findViewById(R.id.btn_htluas);
        hasil_volume = (TextView) view.findViewById(R.id.hasil_volume);
        hasil_luaspm = (TextView) view.findViewById(R.id.hasil_luaspm);

        hBtn_hvolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung_volume(v);
            }
        });
        hBtn_hluas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung_luas(v);
            }
        });
    }

    public void hitung_volume(View v) {
        try {
            double r = Integer.parseInt(rjari_jari.getText().toString());
            double t = Integer.parseInt(ttinggi.getText().toString());
            double volume = 3.14 * 1 / 3 * r * r * t;
            hasil_volume.setText(String.valueOf(volume));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hitung_luas(View v) {
        try {
            double r = Integer.parseInt(rjari_jari.getText().toString());
            double s = Integer.parseInt(sselimut.getText().toString());
            double luas = (3.14 * r * s * (r + s));
            hasil_luaspm.setText(String.valueOf(luas));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
