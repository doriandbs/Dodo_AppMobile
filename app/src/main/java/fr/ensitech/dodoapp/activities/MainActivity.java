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
import android.widget.Toast;

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

        editTextNom = findViewById(R.id.editText_nom);
        editTextPrenom = findViewById(R.id.editText_prenom);
        btnSuivant = findViewById(R.id.btn_suivant);

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNom.getText().toString().trim().isEmpty()
                        || editTextPrenom.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Tous les champs sont obligatoires", Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i(TAG,"Nom = "+ editTextNom.getText().toString()
                + "Prénom = " + editTextPrenom.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);

                //sans passer de paramètres à la prochaine activite
                // startActivity(intent);
                //en récupérant des data de la prochaine activité
               // setResult(Activity.RESULT_OK, intent);
                startActivityForResult(intent,1);

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