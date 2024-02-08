package fr.ensitech.dodoapp.activities;

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
    private Double resultat;
    private String operationCourante = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        textViewResult = findViewById(R.id.textViewResult);
        textViewLastOperation = findViewById(R.id.textViewLastOperation);

        setNumericOnClickListener();
        setOperatorOnClickListener();
    }

    private void setNumericOnClickListener() {
        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            textViewResult.append(button.getText());
            textViewLastOperation.setText(null);
        };

        findViewById(R.id.buttonZero).setOnClickListener(listener);
        findViewById(R.id.buttonOne).setOnClickListener(listener);
        findViewById(R.id.buttonTwo).setOnClickListener(listener);
        findViewById(R.id.buttonThree).setOnClickListener(listener);
        findViewById(R.id.buttonFour).setOnClickListener(listener);
        findViewById(R.id.buttonFive).setOnClickListener(listener);
        findViewById(R.id.buttonSix).setOnClickListener(listener);
        findViewById(R.id.buttonSeven).setOnClickListener(listener);
        findViewById(R.id.buttonEight).setOnClickListener(listener);
        findViewById(R.id.buttonNine).setOnClickListener(listener);
        findViewById(R.id.buttonPoint).setOnClickListener(listener);
    }


    private void setOperatorOnClickListener() {
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
        findViewById(R.id.buttonMulti).setOnClickListener(listener);
        findViewById(R.id.buttonDiv).setOnClickListener(listener);

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
                Double resultat = calculer();
                textViewLastOperation.setText("Valeur 1 = " + valeur1
                        + "\nOperateur :" + operationCourante
                        + "\nValeur 2 = " + valeur2
                        + "\nResultat = " + resultat);
                valeur1 = "";
                operationCourante = "";
            }
        });
    }


    private Double calculer() {
        if(valeur1 != null && !valeur1.isEmpty()) {
            try {
                valeur2 = textViewResult.getText().toString(); 
                switch(operationCourante) {
                    case "+":
                        resultat = Double.parseDouble(valeur1) + Double.parseDouble(valeur2);
                        break;
                    case "-":
                        resultat =Double.parseDouble(valeur1) - Double.parseDouble(valeur2);
                        break;
                    case "*":
                        resultat = Double.parseDouble(valeur1) * Double.parseDouble(valeur2);
                        break;
                    case "/":
                        resultat = Double.parseDouble(valeur1) / Double.parseDouble(valeur2);
                        break;
                }
                textViewResult.setText(resultat.toString());
                textViewLastOperation.setText(null);
            } catch (Exception e) {
                textViewResult.setText("Erreur");
            }
        }
        return resultat;

    }

}