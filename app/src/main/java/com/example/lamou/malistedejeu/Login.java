package com.example.lamou.malistedejeu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    //déclaration des variables
        private Button MonBoutonBack;
        private EditText Nom;
        private EditText FavoriteGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set des variable avec l'activité
            MonBoutonBack=(Button) findViewById(R.id.B_Valider);
            Nom=(EditText) findViewById(R.id.ET_Nom);
            FavoriteGame=(EditText) findViewById(R.id.ET_FavoriteGame);

        //création du OnClickListener permettant de retourner à la page principale en envoyant les informations
            MonBoutonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //si le nom et le jeu préféré sont mentionner alors ...
                        if (Nom.getEditableText().toString().length() > 0 && FavoriteGame.getEditableText().toString().length() > 0) {

                            //... on envoie les données à la page d'acceuil
                                Intent Intent2 = new Intent(Login.this, MainActivity.class);
                                User MonUtilisateur = new User(Nom.getEditableText().toString(), FavoriteGame.getEditableText().toString());
                                Intent2.putExtra("MON_USER", MonUtilisateur);
                                setResult(RESULT_OK, Intent2);
                                finish();
                    //sinon ...
                        } else {

                            //... on retourne à la page d'acceuil sans rien envoyer
                                setResult(RESULT_CANCELED);
                                finish();
                        }

                }
            });
    }

}
