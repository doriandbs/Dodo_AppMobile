package fr.ensitech.dodoapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.ensitech.dodoapp.R;

public class CalculatriceActivity extends AppCompatActivity {

    private TextView textViewResult, textViewLastOperation;
    private String valeur1 = null;
    private String valeur2 = null;
    private Float  resultat;
    private String operationCourante = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        textViewResult = findViewById(R.id.textViewResult);
        textViewLastOperation = findViewById(R.id.textViewLastOperation);

        chiffresListener();
        operationListener();
    }

    private void chiffresListener() {
        View.OnClickListener listener = v -> {
            if(textViewResult.getText().toString().equals("0")){
                textViewResult.setText(null);
            }
                Button button = (Button) v;
                textViewResult.setText(textViewResult.getText().toString().concat(button.getText().toString()));
                textViewLastOperation.setText(null);
        };

        findViewById(R.id.buttonZero).setOnClickListener(listener);
        findViewById(R.id.buttonUn).setOnClickListener(listener);
        findViewById(R.id.buttonDeux).setOnClickListener(listener);
        findViewById(R.id.buttonTrois).setOnClickListener(listener);
        findViewById(R.id.buttonQuatre).setOnClickListener(listener);
        findViewById(R.id.buttonCinq).setOnClickListener(listener);
        findViewById(R.id.buttonSix).setOnClickListener(listener);
        findViewById(R.id.buttonSept).setOnClickListener(listener);
        findViewById(R.id.buttonHuit).setOnClickListener(listener);
        findViewById(R.id.buttonNeuf).setOnClickListener(listener);
        findViewById(R.id.buttonPoint).setOnClickListener(listener);
    }


    private void operationListener() {
        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            if (valeur1 != null && !valeur1.isEmpty()) {
                calculer();
                operationCourante = button.getText().toString();
                textViewLastOperation.setText(valeur1 + operationCourante);
                textViewResult.setText(null);
            } else {
                try {
                    valeur1 = textViewResult.getText().toString();
                    operationCourante = button.getText().toString();
                    textViewLastOperation.setText(valeur1 + operationCourante);
                    textViewResult.setText(null);
                } catch (Exception e) {
                    textViewResult.setText("Erreur");
                }
            }
        };

        findViewById(R.id.buttonPlus).setOnClickListener(listener);
        findViewById(R.id.buttonMoins).setOnClickListener(listener);
        findViewById(R.id.buttonMultiplier).setOnClickListener(listener);
        findViewById(R.id.buttonDiviser).setOnClickListener(listener);

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valeur1 = "";
                valeur2 = "";
                textViewResult.setText("");
                textViewLastOperation.setText("");
            }
        });

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float resultat = calculer();
                valeur1 = "";
                afficherDerniereOperation();

            }
        });
    }


    private Float calculer() {
        if(valeur1 != null && !valeur1.isEmpty()) {
            try {
                valeur2 = textViewResult.getText().toString(); 
                switch(operationCourante) {
                    case "+":
                        resultat = Float.parseFloat(valeur1) + Float.parseFloat(valeur2);
                        break;
                    case "-":
                        resultat =Float.parseFloat(valeur1) - Float.parseFloat(valeur2);
                        break;
                    case "*":
                        resultat = Float.parseFloat(valeur1) * Float.parseFloat(valeur2);
                        break;
                    case "/":
                        resultat = Float.parseFloat(valeur1) / Float.parseFloat(valeur2);
                        break;
                }
                textViewResult.setText(resultat.toString());
                textViewLastOperation.setText(null);
                sauvegarderDerniereOperation("Valeur 1 = " + valeur1
                        + "\nOperateur :" + operationCourante
                        + "\nValeur 2 = " + valeur2
                        + "\nResultat = " + resultat);
            } catch (Exception e) {
                textViewResult.setText("Erreur");
            }
        }
        return resultat;

    }


    private void sauvegarderDerniereOperation(String operation) {
        SharedPreferences prefs = getSharedPreferences("calculatrice", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("derniereOperation", operation);
        editor.apply();
    }

    private void afficherDerniereOperation() {
        SharedPreferences prefs = getSharedPreferences("calculatrice", MODE_PRIVATE);
        String derniereOperation = prefs.getString("derniereOperation", "");
        textViewLastOperation.setText(derniereOperation);
    }

}