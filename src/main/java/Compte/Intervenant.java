package Compte;

import Reclamation.Reclamation;
import Tache.LigneTache;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Intervenant extends AbstractIntervenant{
   String nom;
   String dateDebut;
   String dateFin;
   String profession;


    public Intervenant(Integer id, String adresse, String mail, String iban, String bic, String mdp) {
        super(id, adresse, mail, iban, bic, mdp);
    }

    @Override
    public void entrepreise(String nom, String dateDebut, String dateFin, String profession) {
        nom=this.nom;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.profession=profession;
    }

    public void envoyerMessageTache(String contenu, LigneTache ligneTache){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        ligneTache.addMessage(new MessageIntervenant(date,contenu,this));
    }


    public void envoyerMessageReclamation(String contenu, Reclamation reclamtion){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        reclamtion.addMessage(new MessageIntervenant(date,contenu,this));
    }

    public void refuseTache(LigneTache lignetahce){
        lignetahce.addRefuse(this);
    }

    public void accepterTache(LigneTache ligneTache){
        ligneTache.setEtatLT("accepte");
        ligneTache.accpteTache((this));
    }


}
