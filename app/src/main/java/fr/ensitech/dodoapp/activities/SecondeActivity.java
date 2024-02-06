package fr.ensitech.dodoapp.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import fr.ensitech.dodoapp.R;
import fr.ensitech.dodoapp.tags.Tags;

public class SecondeActivity extends AppCompatActivity {

    private final String TAG = Tags.SECONDE_ACTIVITY;


    private Button buttonPrecedent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);
        buttonPrecedent = findViewById(R.id.btn_precedent);
    }

    public void btnPrecedent(View view){

        Intent intent = new Intent(SecondeActivity.this,MainActivity.class);
        //sans renvoyer de datas -> startActivity(intent)
        intent.putExtra("nom",MainActivity.getEditTextNom().getText().toString());
        intent.putExtra("prenom",MainActivity.getEditTextPrenom().getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }


}