package fr.rjammet.mainproject.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import fr.rjammet.mainproject.R;

public class Question3 extends AppCompatActivity {

    private ListView listViewContinents;
    private String[] lesContinents = {"Afrique", "Amérique", "Asie", "Europe", "Océanie"};
    private TextView txtMessage;
    private Button btnVerifier;
    private Button btnSuivante;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        txtMessage = findViewById(R.id.textView3);
        btnVerifier = findViewById(R.id.buttonVerif3);
        btnSuivante = findViewById(R.id.buttonNext3);

        Intent intent = getIntent();
        name = intent.getStringExtra("NOM");

        listViewContinents = findViewById(R.id.selector);
        listViewContinents.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, lesContinents));

        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message;

            switch (view.getId()) {
                case R.id.buttonQ1Verif :
                    if (lesContinents[listViewContinents.getCheckedItemPosition()].equals("Amérique")) {
                        message = "Bonne réponse " + name.toUpperCase() + " !";
                    }
                    else {
                        message = "Mauvaise réponse " + name.toUpperCase() + " !";
                    }
                    txtMessage.setText(message);
                    break;

                case R.id.buttonQ2Next :
                    Intent question4 = new Intent(Question3.this, Question4.class);

                    question4.putExtra("NOM", name);
                    startActivity(question4);
                    break;
            }
        }
    };
}