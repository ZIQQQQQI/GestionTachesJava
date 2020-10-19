package Tache;

import Compte.AbstractIntervenant;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLigneTache {
    protected AbstractIntervenant intervenant;
    protected Integer codeLT;
    protected String libLT;
    protected Float prixLT;
    protected String etatLT;
    protected Integer nbPersonne;
    protected ArrayList<AbstractMessage> listMessage=new ArrayList<>();

    public AbstractLigneTache(AbstractIntervenant intervenant, String libLT, Float prixLT, String etatLT, Integer nbPersonne) {
        this.intervenant = intervenant;
        this.libLT = libLT;
        this.prixLT = prixLT;
        this.etatLT = etatLT;
        this.nbPersonne = nbPersonne;
    }

    public void setPrixLT(Float prixLT) {
        this.prixLT = prixLT;
    }
}
