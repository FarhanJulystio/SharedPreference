package com.farhan.usingpreferencesfj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Code ini dideklarasi dan akan Menginisialisasi variable nama dengan Label Nama yang berasal dari Layout MainActivity */
        TextView nama = findViewById(R.id.tv_namaMain);

        /* Code ini akan Men-set Label yang dimana Nama dengan data User sedang login dari Preferences */
        nama.setText(Preferences.getLoggedInUser(getBaseContext()));

        /* Code ini akan Men-set Status dan User yang sedang login menjadi default atau kosong yang ada di
         * Data Preferences. Kemudian menuju ke LoginActivity*/
        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code ini akan Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });
    }
}