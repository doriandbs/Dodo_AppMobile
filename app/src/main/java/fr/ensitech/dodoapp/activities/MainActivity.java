package fr.ensitech.dodoapp.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

import fr.ensitech.dodoapp.R;
import fr.ensitech.dodoapp.tags.Tags;

public class MainActivity extends AppCompatActivity {

    private static EditText editTextNom, editTextPrenom;
    private Button btnSuivant;

    private final String TAG = Tags.MAIN_ACTIVITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Log.i(TAG,"Nom et prénom récupéré"+ data.getStringExtra("nom") + data.getStringExtra("prenom"));

        }else{
                Log.i(TAG,"Pas de données");
        }
    }

    public static EditText getEditTextNom() {
        return editTextNom;
    }

    public static EditText getEditTextPrenom() {
        return editTextPrenom;
    }
}