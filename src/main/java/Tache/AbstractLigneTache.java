package Tache;

import Compte.AbstractIntervenant;

public abstract class AbstractLigneTache {
    protected AbstractIntervenant intervenant;
    protected Integer codeLT;
    protected String libLT;
    protected Float prixLT;
    protected String etatLT;
    protected Integer nbPersonne;

    public void setPrixLT(Float prixLT) {
        this.prixLT = prixLT;
    }
}
