package com.example.lamou.malistedejeu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Reception extends AppCompatActivity {

    //déclaration des variables
        private String EXTRA_CHOIX="EXTRA_CHOIX";
        private ImageView MonImage;
        private TextView MontTitre;
        private TextView MaDescription;
        private Button MonBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set des variables avec l'activité
            MonImage=(ImageView) findViewById(R.id.IV_ImageDeProfile);
            MontTitre=(TextView) findViewById(R.id.TV_Titre);
            MaDescription=(TextView) findViewById(R.id.TV_Description);
            MonBouton=(Button) findViewById(R.id.B_BackToHub);

        //récupération de l'Intent de la page d'acceuil
            Intent MonIntent= getIntent();

        //en fonction du choix de l'utilisateur on charge différentes données
            switch (MonIntent.getStringExtra(EXTRA_CHOIX)){
                case "The Witcher":MonImage.setImageResource(R.drawable.witcher1image);
                    MontTitre.setText(getText(R.string.titre_the_witcher));
                    MaDescription.setText(getText(R.string.des_the_witcher));
                    break;
                case "The Witcher 2 : Assassins Of Kings":MonImage.setImageResource(R.drawable.witcher2image);
                    MontTitre.setText(getText(R.string.titre_the_witcher_2));
                    MaDescription.setText(getText(R.string.des_the_witcher_2));
                    break;
                case "The Witcher 3 : Wild Hunt":MonImage.setImageResource(R.drawable.witcher3image);
                    MontTitre.setText(getText(R.string.titre_the_witcher_3));
                    MaDescription.setText(getText(R.string.des_the_witcher_3));
                    break;
                case "Deception 4: The Nightmare Princess":MonImage.setImageResource(R.drawable.deceptionthenightmareprincess);
                    MontTitre.setText(getText(R.string.titre_the_deception_4));
                    MaDescription.setText(getText(R.string.des_the_deception_4));
                    break;
                case "Fire Emblem : Awakening":MonImage.setImageResource(R.drawable.fire_emblem_awakening);
                    MontTitre.setText(getText(R.string.titre_fire__emblem__awakening));
                    MaDescription.setText(getText(R.string.des_fire__emblem__awakening));
                    break;
                case "Mortal Kombat 9":MonImage.setImageResource(R.drawable.mortal_kombat_9);
                    MontTitre.setText(getText(R.string.titre_mortal__kombat_9));
                    MaDescription.setText(getText(R.string.des_mortal__kombat_9));
                    break;
                case "Motal Kombat X":MonImage.setImageResource(R.drawable.mortal_kombat_10);
                    MontTitre.setText(getText(R.string.titre_mortal__kombat_10));
                    MaDescription.setText(getText(R.string.des_mortal__kombat_10));
                    break;
                case "Nier : Automata":MonImage.setImageResource(R.drawable.nier_automata);
                    MontTitre.setText(getText(R.string.titre_nier__automata));
                    MaDescription.setText(getText(R.string.des_nier__automata));
                    break;
            }
            setTitle(MonIntent.getStringExtra(EXTRA_CHOIX));

        //création de la fonction OnClickListener permettan de revenir à la page d'acceuil
            MonBouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent BackIntent = new Intent(Reception.this, MainActivity.class);
                    startActivity(BackIntent);
                }
            });
    }

}
