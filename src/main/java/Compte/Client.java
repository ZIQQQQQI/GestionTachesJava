package Compte;

import Donnee.Competence;
import Reclamation.Reclamation;
import Tache.LigneTache;
import Tache.AbstractLigneTache;
import Tache.Tache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Client extends AbstractClient {
    ArrayList<Tache> mesTache;
    public Client(){
        super();
    };

    public Client(Integer id,String adresse, String mail, String iban, String bic, String mdp) {
        super(id,adresse, mail, iban, bic, mdp);
        this.mesTache=new ArrayList<Tache>();
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
    //envoyer message pour une ligne de tache
    public void envoyerMessageTache(String contenu, LigneTache ligneTache){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        ligneTache.addMessage(new messageClient(date,contenu,this));
    }
    //envoyer message pour une reclamtion
    public void envoyerMessageReclamtion(String contenu, Reclamation reclamation){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        reclamation.addMessage(new messageClient(date,contenu,this));
    }

    //proprose une tache
    public Tache proposeTache(Integer id,String des,String libel,Integer duree){
        Tache t1= new Tache(id,des,this,libel,duree);
        //mesTaches.add(t1);
        return t1 ;
    };





}
