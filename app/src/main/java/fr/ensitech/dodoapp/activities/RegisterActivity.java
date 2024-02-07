package fr.ensitech.dodoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.ensitech.dodoapp.R;

public class RegisterActivity extends AppCompatActivity {


    private EditText registerNom,registerPrenom,registerEmail,registerPassword,registerConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerNom = findViewById(R.id.editText_register_nom);
        registerPrenom = findViewById(R.id.editText_register_prenom);
        registerEmail=findViewById(R.id.editText_register_email);
        registerPassword = findViewById(R.id.editText_register_password);
        registerConfirmPassword=findViewById(R.id.editText_register_confirm_password);

    }

    public void validate(View view){

        String password = registerPassword.getText().toString();
        String confirmedPassword = registerConfirmPassword.getText().toString();
        if(registerNom.getText().toString().trim().isEmpty() ||
                registerPrenom.getText().toString().trim().isEmpty()||
                registerEmail.getText().toString().trim().isEmpty()||
                registerPassword.getText().toString().trim().isEmpty()||
                registerConfirmPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Tout les champs doivent être remplis", Toast.LENGTH_LONG).show();
        }else if(!validateConfirmationPassword(password,confirmedPassword)){
            Toast.makeText(this,"Les mots de passes ne sont pas identiques", Toast.LENGTH_LONG).show();

        }else{
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }

    private Boolean validateConfirmationPassword(String password, String confirmedPassword){
        return password.equals(confirmedPassword);
    }
}