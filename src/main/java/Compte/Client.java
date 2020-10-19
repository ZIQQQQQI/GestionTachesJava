package Compte;

import Tache.LigneTache;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends AbstractClient {
    public Client(Integer id,String adresse, String mail, String iban, String bic, String mdp) {
        super(id,adresse, mail, iban, bic, mdp);
    }

    //si cest une entreprise
    @Override
    public void entrepreise(String nom, String dateDebut, String dateFin, String profession) {
        super.nomE=nom;
        super.dateDebut=dateDebut;
        super.dateFin=dateFin;
        super.profession=profession;

    }
    //si cest une personne
    @Override
    public void personne(String nom,String prenom) {
        super.nomP=nom;
        super.prenomP=prenom;

    }

    public void envoyerMessageTache(String contenu, LigneTache ligneTache){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        ligneTache.addMessage(new messageClient(date,contenu,this));
    }


}
