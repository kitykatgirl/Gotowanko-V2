package com.example.skprzepisy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrzepisActivity extends AppCompatActivity {

    TextView textViewNazwaPrzepisu, textViewSkladniki, textViewOpis;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_przepis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int idPrzepisuDoWyswietlenia = getIntent().getIntExtra("ID",0);
        Przepis przepis = RepozytoriumPrzepisow.zwrocPrzepisId(idPrzepisuDoWyswietlenia);
        Toast.makeText(PrzepisActivity.this, ""+idPrzepisuDoWyswietlenia, Toast.LENGTH_SHORT).show();

        textViewNazwaPrzepisu = findViewById(R.id.textViewNazwa);
        textViewSkladniki = findViewById(R.id.textViewSkladniki);
        textViewOpis = findViewById(R.id.textViewOpis);

        WyswietlPrzepis(przepis);


    }

    private void WyswietlPrzepis(Przepis przepis){
        textViewNazwaPrzepisu.setText(przepis.getNazwaPrzepisu());
    }
}