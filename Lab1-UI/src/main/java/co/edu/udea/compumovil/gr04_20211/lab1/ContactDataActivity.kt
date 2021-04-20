package co.edu.udea.compumovil.gr04_20211.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class ContactDataActivity : AppCompatActivity() {
    private val paisesLatinoamerica = arrayOf(
        "Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Costa Rica", "Cuba", "Ecuador",
        "El Salvador", "Guayana Francesa", "Granada", "Guatemala", "Guayana", "Haití", "Honduras",
        "Jamaica", "México", "Nicaragua", "Paraguay", "Panamá", "Perú", "Puerto Rico",
        "República Dominicana", "Surinam", "Uruguay", "Venezuela");

    private val ciudadesColombia = arrayOf(
        "Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena de Indias", "Soacha", "Cúcuta", "Soledad",
        "Bucaramanga", "Bello", "Villavicencio", "Ibagué", "Santa Marta", "Valledupar", "Manizales",
        "Pereira", "Montería", "Neiva", "Pasto", "Armenia");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data);

        val editTextPais = findViewById<AutoCompleteTextView>(R.id.pais);
        val editTextCiudad = findViewById<AutoCompleteTextView>(R.id.ciudad);
        val adapterPais = ArrayAdapter(this,
            R.layout.custom_item, R.id.autoCompleteItem, paisesLatinoamerica
        )
        val adapterCiudad = ArrayAdapter(this,
            R.layout.custom_item, R.id.autoCompleteItem, ciudadesColombia
        )
        editTextPais.setAdapter(adapterPais);
        editTextCiudad.setAdapter(adapterCiudad);

    }

    fun siguienteClick(view: View) {
        //Hacer el logcat que falta, imprimiendo los campos y validando los obligatorios


    }
}