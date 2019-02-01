package com.example.lamou.malistedejeu;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    //déclaration des données de la class
        private String Nom;
        private String FavoriteGame;

    //création  de la fonction Creator permettant de créer un Parcel depuis un User
        public static final Parcelable.Creator<User> CREATOR = new
                Parcelable.Creator<User>() {
                    @Override
                    public User createFromParcel(Parcel source) {
                        return new User(source);
                    }

                    @Override
                    public User[] newArray(int size) {
                        return new User[size];
                    }
                };

    //création du constructeur de User depuis un Parcel
        public User(Parcel source){
            this.SetNom(source.readString());
            this.SetFavoriteGame(source.readString());
        }

    //création du constructeur de User depuis des strings
        public User(String Nom, String FavoriteGame){
            super();
            this.SetNom(Nom);
            this.SetFavoriteGame(FavoriteGame);
        }

    //création des mutateurs et accesseurs
        public String GetNom(){
            return this.Nom;
        }

        public void SetNom(String Nom){
            this.Nom=Nom;
        }

        public String GetFavoriteGame(){
            return this.FavoriteGame;
        }

        public void SetFavoriteGame(String FavoriteGame){
            this.FavoriteGame=FavoriteGame;
        }

        public  int describeContents(){
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags){
            dest.writeString(this.Nom);
            dest.writeString(this.FavoriteGame);
        }
}
