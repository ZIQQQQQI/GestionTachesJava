package Tache;

import Compte.AbstractIntervenant;

public class LigneTache extends AbstractLigneTache {
    public LigneTache(AbstractIntervenant intervenant, String libLT, Float prixLT, String etatLT, Integer nbPersonne) {
        super(intervenant, libLT, prixLT, etatLT, nbPersonne);
    }
}
