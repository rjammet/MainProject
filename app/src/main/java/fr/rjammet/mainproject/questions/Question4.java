package fr.rjammet.mainproject.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import fr.rjammet.mainproject.EndActivity;
import fr.rjammet.mainproject.R;

public class Question4 extends AppCompatActivity {

    private ListView listViewCouleurs;
    private String[] lesCouleurs = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"} ;
    private TextView txtMessage;
    private Button btnVerifier;
    private Button btnSuivante;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        txtMessage = findViewById(R.id.textMessage4);
        btnVerifier = findViewById(R.id.buttonVerif4);
        btnSuivante = findViewById(R.id.buttonEnd);

        Intent intent = getIntent();
        name = intent.getStringExtra("NOM");

        listViewCouleurs = findViewById(R.id.listView4);
        listViewCouleurs.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, lesCouleurs));

        btnVerifier.setOnClickListener(EcouteurBouton);
        btnSuivante.setOnClickListener(EcouteurBouton);
    }

    public View.OnClickListener EcouteurBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String message;

            switch (view.getId()) {
                case R.id.buttonVerif4 :
                    String choix = "";
                    SparseBooleanArray lesChoix = listViewCouleurs.getCheckedItemPositions();

                    for (int i=0; i<lesChoix.size();i++) {
                        if (lesChoix.valueAt(i))
                            choix += Integer.toString(lesChoix.keyAt(i));
                    }
                    if (choix.equals("235")) {
                        message = "Bonne réponse " + name.toUpperCase();
                    } else {
                        message = "Mauvaise réponse " + name.toUpperCase();
                    }
                    txtMessage.setText(message);
                    break;

                case R.id.buttonEnd :
                    Intent end = new Intent(Question4.this, EndActivity.class);

                    end.putExtra("NOM", name);
                    startActivity(end);
                    break;
            }
        }
    };
}