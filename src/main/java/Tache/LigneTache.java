package Tache;

import Compte.AbstractIntervenant;
import Compte.Intervenant;
import Donnee.AbstractCompetence;

import java.util.ArrayList;

public class LigneTache extends AbstractLigneTache {
    ArrayList<Intervenant> listRefuse=new ArrayList<>();

    public LigneTache(AbstractCompetence competence, Integer id, Tache tache, String libLT, double prixLT, String etatLT, Integer nbPersonne) {
        super(competence,id,tache,libLT, prixLT, etatLT, nbPersonne);
        tache.addTache(this);
    }



    public void addMessage(AbstractMessage message){
        super.listMessage.add(message);
    }

    //obtenir chaque attribut dans abstractLigne
    public Tache getTache() {
        return super.tache;
    }

    public AbstractIntervenant getIntervenant() {
        return super.intervenant;
    }

    public Integer getCodeLT() {
        return super.codeLT;
    }

    public String getLibLT() {
        return super.libLT;
    }

    public Double getPrixLT() {
        return super.prixLT;
    }

    public String getEtatLT() {
        return super.etatLT;
    }

    public Integer getNbPersonne() {
        return super.nbPersonne;
    }

    public ArrayList<AbstractIntervenant> getAccepte(){
        return this.listIntervenant;
    }

    public ArrayList<AbstractMessage> getListMessage() {
        return super.listMessage;
    }

    public ArrayList<Intervenant> getListRefuse() {
        return listRefuse;
    }


    //add un intervenant qui a refuse cette tache
    public void addRefuse(Intervenant intervenant){
        this.listRefuse.add(intervenant);
    }
    //add un intervenant qui a accepte cette tache;
    public void accpteTache(Intervenant intervenant){
        this.listIntervenant.add(intervenant);
    }
}
