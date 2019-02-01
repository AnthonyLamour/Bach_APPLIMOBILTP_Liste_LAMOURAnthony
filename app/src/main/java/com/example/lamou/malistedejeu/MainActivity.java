package com.example.lamou.malistedejeu;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //déclaration des variables
        //variables liées au RecyclerView
            private RecyclerView monRecyclerView;
            private RecyclerView.Adapter monAdapter;
            private RecyclerView.LayoutManager monLayoutManager;

        //variables liées à la liste
            private String[] monDataTitre = {"The Witcher","The Witcher 2 : Assassins Of Kings","The Witcher 3 : Wild Hunt","Deception 4: The Nightmare Princess","Fire Emblem : Awakening","Mortal Kombat 9","Motal Kombat X","Nier : Automata"};
            private String[] monDataDes = {"clicker pour voir","clicker pour voir","clicker pour voir","clicker pour voir","clicker pour voir","clicker pour voir","clicker pour voir","clicker pour voir"};
            private String[] monDataImage = {"witcher","witcher","witcher","deception","fire_emblem_awakening","mortal_kombat","mortal_kombat","nier_automata"};

        //variables liées au login
            private TextView FavoriteGame;
            private TextView LogAs;
            private Button Login;
            private String MON_USER="MON_USER";
            private int MonRes;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        //set du recyclerview
            monRecyclerView= (RecyclerView)findViewById(R.id.RV_Main);
            monRecyclerView.setHasFixedSize(true);
            monLayoutManager = new LinearLayoutManager(this);
            monRecyclerView.setLayoutManager(monLayoutManager);
        //set de l'adapter
            monAdapter= new rec_adapter(monDataTitre,monDataDes,monDataImage);
        //liaison du recyclerview et de l'adapter
            monRecyclerView.setAdapter(monAdapter);

        //set du login
            FavoriteGame=(TextView) findViewById(R.id.TV_FavoriteGame);
            LogAs=(TextView) findViewById(R.id.TV_LogAs);
            Login=(Button) findViewById(R.id.B_Login);

            //création de la fonction OnClick permettant d'accéder à la page login
            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent MonIntent= new Intent(MainActivity.this,Login.class);
                    startActivityForResult(MonIntent,MonRes);
                }
            });

        //création de la fonction addOnItemTouchListener permettant d'accéder à la page réception
            monRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent monIntent = new Intent(MainActivity.this,Reception.class);
                    //EXTRA_CHOIX permet de définir quelle données afficher dans la page réception
                    monIntent.putExtra("EXTRA_CHOIX",monDataTitre[position].toString());
                    startActivity(monIntent);
                }
            }));


    }

    //onActivyResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MonRes){

            //si le joueur à renseigner son identifiant et son jeu préféré alors ...
                if (resultCode == RESULT_OK){
                    //... on récupère ces informations
                        User MonUser = data.getParcelableExtra(MON_USER);
                    //on affiche les informations dans les TextView
                        LogAs.setText("Login as : "+MonUser.GetNom());
                        FavoriteGame.setText("Favorite game :"+MonUser.GetFavoriteGame());
                }
            //sinon ...
                else
                {
                    //... on affiche les éléments par défaut
                    LogAs.setText("Login as : anomyme");
                    FavoriteGame.setText("None");
                }

        }
    }
}
