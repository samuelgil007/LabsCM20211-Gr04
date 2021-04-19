package co.edu.udea.compumovil.gr04_20211.lab1

import android.content.Intent
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun onClickContactButton(view: View) {
        val intent = Intent(this, ContactDataActivty::class.java).apply {
        }
        startActivity(intent)
    }
}