package com.hcordeiro.android.InthegraApp.Activities.Linhas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.equalsp.stransthe.Linha;
import com.hcordeiro.android.InthegraApp.Activities.MenuPrincipalActivity;
import com.hcordeiro.android.InthegraApp.InthegraAPI.InthegraServiceSingleton;
import com.hcordeiro.android.InthegraApp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinhasMenuActivity extends AppCompatActivity {
    String TAG = "DetailParada";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "OnCreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas_menu);

        carregarLinhas();
    }

    private void carregarLinhas() {
        Log.i(TAG, "carregarLinhas Called");
        List<Linha> linhas = new ArrayList<>();
        try {
            Log.d(TAG, "Carregando linhas...");
            linhas = InthegraServiceSingleton.getLinhas();
        } catch (IOException e) {
            Log.e(TAG, "Não foi possível recuperar linhas, motivo: " + e.getMessage());
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(LinhasMenuActivity.this);
            alertBuilder.setMessage("Não foi possível recuperar recuperar a lista de Linhas");
            alertBuilder.setCancelable(false);
            alertBuilder.setNeutralButton("Certo",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent intent = new Intent(LinhasMenuActivity.this, MenuPrincipalActivity.class);
                            startActivity(intent);
                        }
                    });
            AlertDialog alert = alertBuilder.create();
            alert.show();
        }

        ArrayAdapter<Linha> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, linhas);

        final ListView listView = (ListView) findViewById(R.id.linhasListView);
        if (listView != null) {
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(LinhasMenuActivity.this, LinhasDetailActivity.class);
                    Linha linha = (Linha) (listView.getItemAtPosition(position));
                    myIntent.putExtra("Linha", linha);
                    startActivity(myIntent);
                }
            });
        }
    }
}
