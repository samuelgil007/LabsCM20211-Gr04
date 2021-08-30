package co.edu.udea.compumovil.gr04_20211.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesActivity  extends AppCompatActivity {

    TextView nombreSitio,descripcionSitio,temperaturaSitio,ubicacionSItio;
    Button volverButton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        nombreSitio = findViewById(R.id.nombreSitio);
        descripcionSitio = findViewById(R.id.descripcionSitio);
        temperaturaSitio = findViewById(R.id.temperaturaSitio);
        ubicacionSItio = findViewById(R.id.ubicacionSItio);
        volverButton = findViewById(R.id.volver);
        nombreSitio.setText(getIntent().getStringExtra("nombre"));
        descripcionSitio.setText(getIntent().getStringExtra("descripcion"));
        temperaturaSitio.setText(getIntent().getStringExtra("temperatura"));
        ubicacionSItio.setText(getIntent().getStringExtra("localizacion"));
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}