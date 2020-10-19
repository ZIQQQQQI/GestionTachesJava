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
    protected Float prixLT;
    protected String etatLT;
    protected Integer nbPersonne;
    protected AbstractCompetence competence;
    protected ArrayList<AbstractMessage> listMessage=new ArrayList<>();
    protected ArrayList<AbstractIntervenant> listIntervenant;
    public AbstractLigneTache(AbstractCompetence competence,Integer id,Tache tache,AbstractIntervenant intervenant, String libLT, Float prixLT, String etatLT, Integer nbPersonne) {
        this.competence=competence;
        this.intervenant = intervenant;
        this.libLT = libLT;
        this.prixLT = prixLT;
        this.etatLT = etatLT;
        this.nbPersonne = nbPersonne;
        this.tache=tache;
        this.idLT=id;
        this.listIntervenant=new ArrayList<>();

    }

    public void setPrixLT(Float prixLT) {
        this.prixLT = prixLT;
    }


}
