package fr.rjammet.mainproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.rjammet.mainproject.questions.Question1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.buttonQ1Verif);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() > 0) {

                    String message = "Bienvenue, " + editText.getText() + "\nCommencez le Quizz !";

                    Toast msg = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
                    msg.setGravity(Gravity.CENTER, 0, 0);
                    msg.show();

                    Intent question1 = new Intent(MainActivity.this, Question1.class);
                    startActivity(question1);

                    question1.putExtra("NOM", editText.getText().toString());

                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Information");
                    builder.setMessage("Vous n'avez pas saisi votre nom !");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            editText.requestFocus();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}