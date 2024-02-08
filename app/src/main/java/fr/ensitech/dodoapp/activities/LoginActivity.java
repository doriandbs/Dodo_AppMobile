package fr.ensitech.dodoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import fr.ensitech.dodoapp.R;
import fr.ensitech.dodoapp.entities.User;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail,loginPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onStart() {
        super.onStart();
/*        sharedPreferences = getSharedPreferences("users",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(email, "");
        User user = gson.fromJson(json, User.class);*/

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeObjects();
    }

    public void retourAccueil(View view) {
        Intent intent = new Intent(LoginActivity.this, AccueilActivity.class);
        startActivity(intent);
        finish();
    }

    public void login(View view) {

        String loginEmailText = loginEmail.getText().toString();
        String loginPasswordText = loginPassword.getText().toString();

        sharedPreferences = getSharedPreferences("users",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(loginEmailText, "");
        User user = gson.fromJson(json, User.class);

        if (loginEmailText.equals(user.getEmail()) && loginPasswordText.equals(user.getMotDePasse())) {
            Toast.makeText(LoginActivity.this, "Vous êtes bien connectés", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(LoginActivity.this, CalculatriceActivity.class);
            startActivity(intent);
        }
        Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();

    }
    private void initializeObjects(){
        loginEmail = findViewById(R.id.editText_login_email);
        loginPassword = findViewById(R.id.editText_login_password);
    }

}