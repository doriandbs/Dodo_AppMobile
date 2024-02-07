package fr.ensitech.dodoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.ensitech.dodoapp.R;
import fr.ensitech.dodoapp.services.NotifService;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail,loginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail = findViewById(R.id.editText_login_email);
        loginPassword = findViewById(R.id.editText_login_password);
    }

    public void retourAccueil(View view) {
        Intent intent = new Intent(LoginActivity.this, AccueilActivity.class);
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        if(loginEmail.getText().toString().equals("dubois.dorian2@gmail.com") && loginPassword.getText().toString().equals("dorian")){
            Toast.makeText(LoginActivity.this, "Vous êtes bien connectés", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, NotifService.class);
            startService(intent);
        }
        Toast.makeText(LoginActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_LONG).show();

    }

}