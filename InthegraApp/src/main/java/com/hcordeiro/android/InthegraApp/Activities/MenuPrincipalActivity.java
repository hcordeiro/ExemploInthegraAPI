package com.hcordeiro.android.InthegraApp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hcordeiro.android.InthegraApp.Activities.Linhas.LinhasMenuActivity;
import com.hcordeiro.android.InthegraApp.Activities.Paradas.ParadasMenuActivity;
import com.hcordeiro.android.InthegraApp.Activities.Rotas.RotasMenuActivity;
import com.hcordeiro.android.InthegraApp.Activities.Veiculos.VeiculosMenuActivity;
import com.hcordeiro.android.InthegraApp.R;


public class MenuPrincipalActivity extends AppCompatActivity {
    String TAG = "MenuPrincipal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_activity);
    }

    public void displayMenuParadasActivity(View view) {
        Log.i(TAG, "displayMenuParadasActivity Called");
        Intent intent = new Intent(this, ParadasMenuActivity.class);
        startActivity(intent);
    }

    public void displayMenuLinhasActivity(View view) {
        Log.i(TAG, "displayMenuLinhasActivity Called");
        Intent intent = new Intent(this, LinhasMenuActivity.class);
        startActivity(intent);
    }

    public void displayMenuVeiculosActivity(View view) {
        Log.i(TAG, "displayMenuVeiculosActivity Called");
        Intent intent = new Intent(this, VeiculosMenuActivity.class);
        startActivity(intent);
    }

    public void displayMenuRotasActivity(View view) {
        Log.i(TAG, "displayMenuRotasActivity Called");
        Intent intent = new Intent(this, RotasMenuActivity.class);
        startActivity(intent);
    }

}
