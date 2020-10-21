package Compte;

import Donnee.Competence;
import Reclamation.Reclamation;
import Tache.LigneTache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Intervenant extends AbstractIntervenant{
   String nom;
   String dateDebut;
   String dateFin;
   String profession;
   ArrayList<Competence> listCompetence;


    public Intervenant(Integer id, String adresse, String mail, Integer iban, Integer bic, String mdp,String debut,String fin) {
        super(id, adresse, mail, iban, bic, mdp,debut,fin);
        this.listCompetence=new ArrayList<>();
    }

    @Override
    public void entrepreise(String nom, String dateDebut, String dateFin, String profession) {
        this.nom=nom;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.profession=profession;
    }

    //envoyer message
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
    //refuse et accpter ligne tache
    public void refuseTache(LigneTache lignetahce){
        lignetahce.addRefuse(this);
    }

    public void accepterTache(LigneTache ligneTache){
        ligneTache.setEtatLT("accepte");
        ligneTache.accpteTache((this));
    }
    //add une competence pour un intervenant
    public void addCompetence(Competence competence){
        this.listCompetence.add(competence);
    }

    //get le nom de intervenant
    public String getNom(){return this.nom;}
    //get list de competence
    public ArrayList<Competence> getListCompetence(){return this.listCompetence;}
    //get


    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getProfession() {
        return profession;
    }
}
