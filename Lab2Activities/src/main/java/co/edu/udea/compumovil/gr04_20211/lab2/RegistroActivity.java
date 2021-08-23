package co.edu.udea.compumovil.gr04_20211.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.udea.compumovil.gr04_20211.lab2.DB.DataBaseV2;
import co.edu.udea.compumovil.gr04_20211.lab2.Daos.UserDao;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.UserEntity;

public class RegistroActivity extends AppCompatActivity {
    EditText usernameTxt, emailTxt, passwordTxt;
    Button registrarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usernameTxt = findViewById(R.id.usernameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        registrarBtn = findViewById(R.id.registrarBtn);

        registrarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(usernameTxt.getText().toString());
                userEntity.setEmail(emailTxt.getText().toString());
                userEntity.setPassword(passwordTxt.getText().toString());
                if(validateInput(userEntity)){
                    //inserta el usuario
                    DataBaseV2 dataBaseV2 = DataBaseV2.getInstanceDb2(getApplicationContext());
                    final UserDao userDao = dataBaseV2.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Usuario Registrado!",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(),"Llene todos los campos!",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(RegistroActivity.this,MainActivity.class));
            }
        });
    }
    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getEmail().isEmpty() ||
                userEntity.getUsername().isEmpty() || userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }

}