package com.PRAYUDO.simpelkejarikonawe.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.PRAYUDO.simpelkejarikonawe.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class strukturOrganisasi extends AppCompatActivity {
    JustifiedTextView justifiedTextViewStruktur;
    ImageView mIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_struktur_organisasi);

        justifiedTextViewStruktur = (JustifiedTextView) findViewById(R.id.strukturOrganisasi);
//
        PhotoView photoZoo = (PhotoView) findViewById(R.id.imageZoom);

        photoZoo.setImageResource(R.drawable.struktur_organisasi);

//        mIcon = (ImageView) findViewById(R.id.ivIcon);
//
//        mIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(strukturOrganisasi.this);
//                View mView = getLayoutInflater().inflate(R.layouts.activity_zoom_image, null);
//                PhotoView photoView = mView.findViewById(R.id.imageZoom);
//                mBuilder.setView(mView);
//                AlertDialog mDialog = mBuilder.create();
//                mDialog.show();
//            }
//        });
    }
}
