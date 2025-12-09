package com.example.skprzepisy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaPrzepisowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_przepisow);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String kategoriaPrzepisu = getIntent().getStringExtra("KATEGORIA");

        ArrayList<Przepis> przepisy = RepozytoriumPrzepisow.zwrocPrzepisyKategoria(kategoriaPrzepisu);
        ListView listView = findViewById(R.id.przedmiotyLV);

        ArrayList<String> nazwy = new ArrayList<>();

        for(int i = 0; i < przepisy.size(); i++){
            nazwy.add(przepisy.get(i).getNazwaPrzepisu());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                ListaPrzepisowActivity.this,
                android.R.layout.simple_list_item_1,
                nazwy
        );
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Przepis przepis = przepisy.get(i);
                int idTegoPrzepisu = przepis.getIdPrzepisu();
                Intent intent = new Intent(ListaPrzepisowActivity.this, PrzepisActivity.class);
                intent.putExtra("ID", idTegoPrzepisu);
                startActivity(intent);
            }
        });
    }
}