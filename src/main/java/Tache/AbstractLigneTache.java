package Tache;

import Compte.AbstractIntervenant;
import Donnee.AbstractCompetence;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLigneTache {

    protected Integer idLT;
    protected Tache tache;
    protected AbstractIntervenant intervenant;
    protected Integer codeLT;
    protected String libLT;
    protected Double prixLT;
    protected String etatLT;
    protected Integer nbPersonne;
    protected AbstractCompetence competence;
    protected ArrayList<AbstractMessage> listMessage=new ArrayList<>();
    protected ArrayList<AbstractIntervenant> listIntervenant;
    public AbstractLigneTache(AbstractCompetence competence,Integer id,Tache tache, String libLT, Double prixLT, String etatLT, Integer nbPersonne) {
        this.competence=competence;
        this.libLT = libLT;
        this.prixLT = prixLT;
        this.etatLT = etatLT;
        this.nbPersonne = nbPersonne;
        this.tache=tache;
        this.idLT=id;
        this.listIntervenant=new ArrayList<>();


    }

    public void setPrixLT(Double prixLT) {
        this.prixLT = prixLT;
    }

    public void setEtatLT(String etat){
        this.etatLT=etat;
    }
}
