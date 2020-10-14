package fr.rjammet.mainproject.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import fr.rjammet.mainproject.R;

public class Question1 extends AppCompatActivity {

    private RadioGroup grpReponse;
    private TextView txtMessage;
    private Button btnVerifier;
    private Button btnSuivante;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        grpReponse = findViewById(R.id.grpReponse);
        txtMessage = findViewById(R.id.message);
        btnVerifier = findViewById(R.id.buttonQ1Verif);
        btnSuivante = findViewById(R.id.buttonQ1Next);

        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);

        Intent intent = getIntent();
        name = intent.getStringExtra("NOM");
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message;

            switch (view.getId()) {
                case R.id.buttonQ1Verif :
                    if (grpReponse.getCheckedRadioButtonId() == R.id.rdbFaux) {
                        message = "Bonne réponse " + name.toUpperCase() + " ! Tokyo est la capitale !";
                    }
                    else {
                        message = "Mauvaise réponse " + name.toUpperCase() + " ! La capitale est Tokyo !";
                    }
                    txtMessage.setText(message);
                    break;
                case R.id.buttonQ1Next :
                    Intent question2 = new Intent(Question1.this, Question2.class);
                    startActivity(question2);
                    break;
            }
        }
    };

}