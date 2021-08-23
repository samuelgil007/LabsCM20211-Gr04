package co.edu.udea.compumovil.gr04_20211.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import co.edu.udea.compumovil.gr04_20211.lab2.DB.DataBaseV2Repository;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;

public class AgregarSitioActivity extends AppCompatActivity {
    DataBaseV2Repository dataBaseV2Repository;

    private void saveSitio() {
        Toast.makeText(getApplicationContext(),"GUARDADO",Toast.LENGTH_SHORT).show();
        dataBaseV2Repository.saveSitio(sitio);
        startActivity(new Intent(AgregarSitioActivity.this, SitiosActivity.class ).putExtra("username", getIntent().getStringExtra("username")));
    }
    SitiosEntity sitio;
    ArrayList<String> images = new ArrayList<>();
    EditText nombreSitio,descripcionSitio,temperaturaSitio,ubicacionSItio;
    Button guardarSitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sitio);
        dataBaseV2Repository = new DataBaseV2Repository(this);
        nombreSitio = findViewById(R.id.nombreSitio);
        descripcionSitio = findViewById(R.id.descripcionSitio);
        temperaturaSitio = findViewById(R.id.temperaturaSitio);
        ubicacionSItio = findViewById(R.id.ubicacionSItio);
        guardarSitio = findViewById(R.id.guardarSitio);

        guardarSitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate_fields();
            }
        });
    }


    private void validate_fields() {
        if(nombreSitio.getText().toString().isEmpty() || descripcionSitio.toString().isEmpty() ||
                temperaturaSitio.getText().toString().isEmpty() || ubicacionSItio.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Llene todos los campos!",Toast.LENGTH_SHORT).show();
            return;
        }
        images.clear();
        images.add("https://cdn.pixabay.com/photo/2020/04/07/08/34/city-5012531_1280.jpg");
        images.add("https://cdn.vox-cdn.com/thumbor/Ksi3v8e1tj1ZcQeRV1ZtmCYIM7k=/0x0:4284x2916/1200x800/filters:focal(1800x1116:2484x1800)/cdn.vox-cdn.com/uploads/chorus_image/image/61918529/NorthBroadSt_Landscape_1_M.Edlow.0.jpg");
        images.add("https://www.thebalancecareers.com/thmb/PsG0_bvGnJ-npJiq8RYiEO6WTT4=/3435x2576/smart/filters:no_upscale()/high-angle-view-of-lower-east-side-manhattan-downtown--new-york-city--usa-640006562-5ae52a273de423003776ae2e.jpg");
        images.add("https://images.pexels.com/photos/1980720/pexels-photo-1980720.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        images.add("https://media-exp1.licdn.com/dms/image/C4D1BAQGgDDaigPLMGQ/company-background_10000/0/1547760860921?e=2159024400&v=beta&t=T8U5oC-jGKHITu_GGIfTDY9udoPbpo97ozlz7oUHXOc");
        images.add("https://lapj.hkspublications.org/wp-content/uploads/sites/19/2019/04/photo-1536334906170-ffa95819c4d4-800x445.jpg");
        images.add("http://www.nic.lat/wp-content/uploads/2020/04/mexico-city-travel.adapt_.1900.1-1-840x560.jpg");
        images.add("https://www.americasquarterly.org/wp-content/uploads/2018/10/metrobus.jpg");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeI99YVJwCejqMcwnVgnpZjnvl5ZSxARMTWLLJmQcBUwvfk3d2Oo_29ncKev7RGTnf0zE&usqp=CAU");


        Collections.shuffle(images);
        sitio =  new SitiosEntity();
        sitio.setNombre(nombreSitio.getText().toString());
        sitio.setDescripcion(descripcionSitio.getText().toString());
        sitio.setTemperatura(temperaturaSitio.getText().toString());
        sitio.setLocalizacion(ubicacionSItio.getText().toString());
        sitio.setImagen(images.get(1));

        saveSitio();
    }


}