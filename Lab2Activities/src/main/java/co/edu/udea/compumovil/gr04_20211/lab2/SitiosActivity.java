package co.edu.udea.compumovil.gr04_20211.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SitiosActivity extends AppCompatActivity {

    TextView tName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        tName = findViewById(R.id.usernameTexto);
        String name = getIntent().getStringExtra("username");
        tName.setText(name);

    }
}