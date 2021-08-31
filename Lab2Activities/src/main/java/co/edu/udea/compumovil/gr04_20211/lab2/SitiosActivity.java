package co.edu.udea.compumovil.gr04_20211.lab2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.compumovil.gr04_20211.lab2.DB.DataBaseV2Repository;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;
import co.edu.udea.compumovil.gr04_20211.lab2.adapter.SitioAdapter;

public class SitiosActivity extends AppCompatActivity {
    ImageView conf;
    TextView tName;
    Button addSitio;
    RecyclerView recyclerView;
    DataBaseV2Repository dataBaseV2Repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        tName = findViewById(R.id.usernameTexto);
        String name = getIntent().getStringExtra("username");
        tName.setText(name);
        bind_views();

    }

    SitioAdapter sitioAdapter;
    List<SitiosEntity> listaSitio = new ArrayList<>();
    private void bind_views(){
        addSitio = findViewById(R.id.crearSitio);
        conf = findViewById(R.id.config);
        recyclerView = findViewById(R.id.recyclerView);
        addSitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SitiosActivity.this, AgregarSitioActivity.class ).putExtra("username", getIntent().getStringExtra("username")));
            }
        });
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SitiosActivity.this, configuracionActivity.class));
            }
        });

        getSitiosDb();
    }

    private void getSitiosDb() {
        dataBaseV2Repository = new DataBaseV2Repository(this);
        dataBaseV2Repository.getAllSitios().observe(this, new Observer<List<SitiosEntity>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<SitiosEntity> _sitiosEntities) {
                // SI LA DB (SITIOS) ESTA VACIA, LA LLENA
                if(_sitiosEntities == null || _sitiosEntities.size() == 0){
                    Toast.makeText(getApplicationContext(),"Generando sitios", Toast.LENGTH_SHORT).show();

                    List<SitiosEntity> sitiosIniciales = new ArrayList<>();

                    SitiosEntity sitio1 = new SitiosEntity("Medellin","https://www.semana.com/resizer/2noyXlnQe0xA-d-VdDa6-acgYhk=/1200x675/filters:format(jpg):quality(50)//cloudfront-us-east-1.images.arcpublishing.com/semana/KI2722K53VBFVN7BR7OMCXSPWM.jpg","Eterna Primavera","26°C","x:1 y:3");
                    SitiosEntity sitio2 = new SitiosEntity("Bogota","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Centro_internacional.JPG/1200px-Centro_internacional.JPG","La nevera bacana :v","24°C","x:1 y:3");
                    SitiosEntity sitio3 = new SitiosEntity("Cancun","https://visaalmundo.com/blog/wp-content/uploads/2020/07/que-hacer-en-cancun-portada.png","lugar en mexico","23°C","x:1 y:3");
                    SitiosEntity sitio4 = new SitiosEntity("Buenos Aires","https://estaticos-cdn.elperiodico.com/clip/80ccbd4a-9d52-4b2a-b2b3-e9c254b3447c_alta-libre-aspect-ratio_default_0.jpg","Lugar en donde esta el obelisco","22°C","x:1 y:3");
                    SitiosEntity sitio5 = new SitiosEntity("Afganistan","https://cdnuploads.aa.com.tr/uploads/Contents/2020/12/03/thumbs_b_c_4dbf1041d59252c2a45ef29163b8c63b.jpg?v=040034","Buen sitio","266°C","x:1 y:3");

                    sitiosIniciales.add(sitio1);
                    sitiosIniciales.add(sitio2);
                    sitiosIniciales.add(sitio3);
                    sitiosIniciales.add(sitio4);
                    sitiosIniciales.add(sitio5);

                    sitiosIniciales.forEach(sitio -> {
                        dataBaseV2Repository.saveSitio(sitio);
                    });

                    getSitiosDb();
                }
                //SE MUESTRAN LOS SITIOS
                listaSitio.clear();
                listaSitio = _sitiosEntities;

                inicializarRecyclerView();
            }
        });
    }

    private void inicializarRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setNestedScrollingEnabled(false);
        sitioAdapter = new SitioAdapter(listaSitio,this);
        recyclerView.setAdapter(sitioAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.config){
            startActivity(new Intent(SitiosActivity.this, configuracionActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void visualizarDetalle(View view) {
        System.out.println(listaSitio.get(1));
    }
}