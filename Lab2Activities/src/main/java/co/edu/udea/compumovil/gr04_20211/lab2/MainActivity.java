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

public class MainActivity extends AppCompatActivity {

    EditText usernameTxt, emailTxt, passwordTxt;
    Button registrarBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        registrarBtn = findViewById(R.id.registrarBtn);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = usernameTxt.getText().toString();
                String passWord = passwordTxt.getText().toString();
                if( userName.isEmpty() || passWord.isEmpty()){
                    Toast.makeText(getApplicationContext(),"LLene todos los campos!", Toast.LENGTH_SHORT).show();
                } else{
                    // se hace la peticion
                    DataBaseV2 dataBaseV2 = DataBaseV2.getInstanceDb2(getApplicationContext());
                    final UserDao userDao = dataBaseV2.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(userName,passWord);
                            if(userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecto.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                String name = userEntity.getUsername();
                                startActivity(new Intent(MainActivity.this,SitiosActivity.class).putExtra("username", name));
                            }
                        }
                    }).start();
                }
            }
        });

        registrarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistroActivity.class));
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