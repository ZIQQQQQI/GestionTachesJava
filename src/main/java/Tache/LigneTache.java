package Tache;

import Compte.AbstractIntervenant;

import java.util.ArrayList;

public class LigneTache extends AbstractLigneTache {


    public LigneTache(Integer id,Tache tache,AbstractIntervenant intervenant, String libLT, Float prixLT, String etatLT, Integer nbPersonne) {
        super(id,tache,intervenant, libLT, prixLT, etatLT, nbPersonne);
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

    public Float getPrixLT() {
        return super.prixLT;
    }

    public String getEtatLT() {
        return super.etatLT;
    }

    public Integer getNbPersonne() {
        return super.nbPersonne;
    }

    public ArrayList<AbstractMessage> getListMessage() {
        return super.listMessage;
    }


}
