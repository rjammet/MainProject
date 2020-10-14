package fr.rjammet.mainproject.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import fr.rjammet.mainproject.R;

public class Question2 extends AppCompatActivity {

    private Spinner spinnerCapitals;
    private String[] capitals = {"Bogota", "Buenos Aires", "Caracas", "Santigo"};
    private TextView txtMessage;
    private Button btnVerifier;
    private Button btnSuivante;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        txtMessage = findViewById(R.id.textMessage2);
        btnVerifier = findViewById(R.id.buttonQ2Verif);
        btnSuivante = findViewById(R.id.buttonQ2Next);

        Intent intent = getIntent();
        name = intent.getStringExtra("NOM");

        spinnerCapitals = findViewById(R.id.spinner1);
        spinnerCapitals.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, capitals));

        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message;

            switch (view.getId()) {
                case R.id.buttonQ1Verif :
                    if (spinnerCapitals.getSelectedItem().toString().equals("Buenos Aires")) {
                        message = "Bonne réponse " + name.toUpperCase() + " !";
                    }
                    else {
                        message = "Mauvaise réponse " + name.toUpperCase() + " !";
                    }
                    txtMessage.setText(message);
                    break;

                case R.id.buttonQ2Next :
                    Intent question3 = new Intent(Question2.this, Question3.class);

                    question3.putExtra("NOM", name);
                    startActivity(question3);
                    break;
            }
        }
    };
}