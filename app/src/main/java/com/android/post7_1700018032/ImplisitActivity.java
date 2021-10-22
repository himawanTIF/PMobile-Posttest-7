package com.android.post7_1700018032;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ImplisitActivity extends Fragment {

    public EditText noTelp, noSMS, isiPesan, cariInstagram, gMaps;
    public Button tblTelp, kirimSMS, CariInsta, CariMaps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Implisit = inflater.inflate(R.layout.activity_implisit, container, false);

        return Implisit;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noTelp = (EditText) view.findViewById(R.id.nomorTelp);
        tblTelp = (Button) view.findViewById(R.id.btn_call);

        tblTelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCall = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + noTelp.getText().toString()));
                startActivity(iCall);
            }
        });
        noSMS = (EditText) view.findViewById(R.id.nomorSMS);
        isiPesan = (EditText) view.findViewById(R.id.isiSMS);
        kirimSMS = (Button) view.findViewById(R.id.btn_SMS);

        kirimSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKirim = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("smsto:" + noSMS.getText().toString()));
                iKirim.putExtra("sms_body", isiPesan.getText().toString());
                startActivity(iKirim);
            }
        });
        cariInstagram = (EditText) view.findViewById(R.id.cariIG);
        CariInsta = (Button) view.findViewById(R.id.btn_CariIG);

        CariInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SearchIG = new Intent(Intent.ACTION_VIEW);
                SearchIG.setData(Uri.parse("https://instagram.com/#q=" + cariInstagram.getText()));
                startActivity(SearchIG);
            }
        });
        gMaps = (EditText) view.findViewById(R.id.Maps);
        CariMaps = (Button) view.findViewById(R.id.btn_cariMaps);

        CariMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Maps = new Intent(Intent.ACTION_VIEW);
                Maps.setData(Uri.parse("geo:0,0?q=" + gMaps.getText().toString()));
                Maps.setPackage("com.google.android.apps.maps");
                startActivity(Maps);
            }
        });
    }
}
