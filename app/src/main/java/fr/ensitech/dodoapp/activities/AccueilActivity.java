package fr.ensitech.dodoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import fr.ensitech.dodoapp.R;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }

    public void seConnecter(View view){
        Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void creerUnCompte(View view){
        Intent intent = new Intent(AccueilActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    
    
}