package co.edu.udea.compumovil.gr04_20211.lab1

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_personal_data.*
import kotlinx.android.synthetic.main.activity_personal_data.view.*
import java.util.*


class PersonalDataActivity : AppCompatActivity() {
    lateinit var estudio : String;
    val c = Calendar.getInstance()
    var year = c.get(Calendar.YEAR)
    var month = c.get(Calendar.MONTH)
    var day = c.get(Calendar.DAY_OF_MONTH)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        //calendario

        if(savedInstanceState!=null){
            year = savedInstanceState.getInt("year");
            month = savedInstanceState.getInt("month");
            day = savedInstanceState.getInt("day");
            fechaId.setText("" + day + "/" + (month + 1) + "/" + year)


        }
        cambioFechaInt.setOnClickListener {
            val dpd = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                        year = mYear;
                        month = mMonth;
                        day = mDay;
                        fechaId.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)

                    },
                    year,
                    month,
                    day
            )
            dpd.show()
        }

        //spinner
        val educaciones = resources.getStringArray(R.array.educacion)

        educacionSpinner.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                educaciones
        )

        educacionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                estudio = educaciones.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        //para q vaya de nombres a apellidos desde el teclado
        nombresId.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                apellidosId.requestFocus()
                return@OnEditorActionListener true
            }
            false
        })

        //boton siguiente
        continuarBtn.setOnClickListener{
            if(!nombresId.text.isEmpty() && !apellidosId.text.isEmpty() && !fechaId.text.isEmpty()){

                if (radioGrupo.getCheckedRadioButtonId() == -1)
                {
                    Log.v("Resultado", " \n" + "Informacion Personal: \n" + nombresId.text.toString() + " " + apellidosId.text.toString() + "\nNació el " + fechaId.text.toString() + "\n" + estudio+ "\n")

                }
                else
                {
                    var rg : RadioGroup;
                    var radioButton : RadioButton
                    rg = findViewById(R.id.radioGrupo);
                    val idSeleccionado = rg.checkedRadioButtonId
                    radioButton = findViewById(idSeleccionado);
                    var genero = "";
                    if(radioButton.text.toString().equals("Mujer")){
                        genero = "Femenino"
                    }else{
                        genero = "Masculino"
                    }
                    Log.v("Resultado", " \n" + "Informacion Personal: \n" + nombresId.text.toString() + " " + apellidosId.text.toString() + "\n"+ genero +"\nNació el " + fechaId.text.toString() + "\n" + estudio+ "\n" )
                }



            }else{
                if(Locale.getDefault().displayLanguage.equals("English")){
                    Toast.makeText(
                            this,
                            "Error, please fill all the inputs with *",
                            Toast.LENGTH_SHORT
                    ).show()
                }else{
                    Toast.makeText(
                            this,
                            "Error, ingrese los datos con *",
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }




    }


//metodo pa q guarde estos datos cuando pasa de vertical a horizontal o viceversa.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("year", this.year);
        outState.putInt("month", this.month);
        outState.putInt("day", this.day);
    }




}