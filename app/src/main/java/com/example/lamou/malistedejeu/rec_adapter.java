package com.example.lamou.malistedejeu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder>
{

    //déclaration des tableaux des données
        private String[] mDataSet;
        private String[] mDataDes;
        private String[] mDataImage;

    //création du ViewHolder
        public static class ViewHolder extends RecyclerView.ViewHolder
        {
            //déclaration des objets de la vue
                public TextView mTextView;
                public TextView mTextViewDes;
                public ImageView IImage;

            //création du constructeur du ViewHolder
                public ViewHolder(View v)
                {
                    super(v);
                    mTextView = (TextView) v.findViewById(R.id.TV_Nom);
                    mTextViewDes = (TextView) v.findViewById(R.id.TV_Description);
                    IImage = (ImageView) v.findViewById(R.id.IV_ImageDeProfile);
                }
        }

    //création du constructeur de l'adapter
        public rec_adapter(String[] monDataset, String[] monDataDes,String[] monDataImage) {
            mDataSet = monDataset;
            mDataDes = monDataDes;
            mDataImage = monDataImage;
        }

    //création de l'initialisation du ViewHolder
        @Override
        public rec_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listeelements, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

    //création des liens entre le viewHolder et les données
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mTextView.setText(mDataSet[position]);
            holder.mTextViewDes.setText(mDataDes[position]);
            switch(mDataImage[position]){
                case "witcher" : holder.IImage.setImageResource(R.drawable.witcherlogo);
                    break;
                case "deception" : holder.IImage.setImageResource(R.drawable.deceptionlogo);
                    break;
                case "fire_emblem_awakening" : holder.IImage.setImageResource(R.drawable.fire_emblem_awakening_logo);
                    break;
                case "mortal_kombat" : holder.IImage.setImageResource(R.drawable.mortal_kombat_logo);
                    break;
                case "nier_automata" : holder.IImage.setImageResource(R.drawable.nier_automata_logo);
                    break;
            }
        }

    //création de la fonction permettant de récupérer le nombre d'éléments de la liste
        @Override
        public int getItemCount() {
            return mDataSet.length;
        }

}
