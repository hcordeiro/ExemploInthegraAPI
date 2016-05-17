package com.hcordeiro.andoird.exemplointhegraapi.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hcordeiro.andoird.exemplointhegraapi.InthegraAPI.InthegraCachedServiceSingleton;
import com.hcordeiro.andoird.exemplointhegraapi.R;
import com.hcordeiro.andoird.exemplointhegraapi.Util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.verifyStoragePermissions(this);
        InthegraCachedServiceSingleton.initInstance();
    }

    public void displayMenuParadasActivity(View view) {
        Intent intent = new Intent(this, DisplayMenuParadasActivity.class);
        startActivity(intent);
    }

    public void displayMenuLinhasActivity(View view) {
        Intent intent = new Intent(this, DisplayMenuLinhasActivity.class);
        startActivity(intent);
    }

}
