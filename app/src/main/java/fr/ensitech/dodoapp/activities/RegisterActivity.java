package fr.ensitech.dodoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.ensitech.dodoapp.R;
import fr.ensitech.dodoapp.entities.User;

public class RegisterActivity extends AppCompatActivity {


    private EditText registerNom,registerPrenom,registerEmail,registerPassword,registerConfirmPassword;
    private TextView errorText;

private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeObjects();
    }

    public void validate(View view){

        String password = registerPassword.getText().toString();
        String confirmedPassword = registerConfirmPassword.getText().toString();
        String nom = registerNom.getText().toString();
        String prenom =  registerPrenom.getText().toString();
        String email = registerEmail.getText().toString();


        if(validateEmpty(nom,prenom,email,password,confirmedPassword)){
            Toast.makeText(this,"Tout les champs doivent être remplis", Toast.LENGTH_LONG).show();
        }else if(!validatePassword(password)){
            errorText.setText("Le mot de passe doit contenir au moins 12 caractères, inclure un nombre et une majuscule, un signe de ponctuation ou un signe spécial (Dollar,Dièse...)");
            return;
        }else if(!validateConfirmationPassword(password,confirmedPassword)){
            Toast.makeText(this,"Les mots de passes ne sont pas identiques", Toast.LENGTH_LONG).show();
        }
        else{
            sharedPreferences = getSharedPreferences("users", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String pseudoId = UUID.randomUUID().toString();

            User user = new User(pseudoId,nom,prenom,email,password);
            Gson gson = new Gson();
            String json = gson.toJson(user);
            editor.putString(user.getEmail(), json);
            editor.apply();

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }
    private Boolean validateEmpty(String nom, String prenom, String password, String email, String confirmedPassword){
        return nom.trim().isEmpty() ||
                prenom.trim().isEmpty()||
                email.trim().isEmpty()||
                password.trim().isEmpty()||
                confirmedPassword.trim().isEmpty();
    }

    private Boolean validateConfirmationPassword(String password, String confirmedPassword){
        return password.equals(confirmedPassword);
    }

    private Boolean validatePassword(String password){
        String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-]).{12,}$";

        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }


    private void initializeObjects(){
        registerNom = findViewById(R.id.editText_register_nom);
        registerPrenom = findViewById(R.id.editText_register_prenom);
        registerEmail=findViewById(R.id.editText_register_email);
        registerPassword = findViewById(R.id.editText_register_password);
        registerConfirmPassword=findViewById(R.id.editText_register_confirm_password);
        errorText = findViewById(R.id.textView_error);
    }
}