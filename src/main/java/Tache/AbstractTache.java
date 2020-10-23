package Tache;

import Compte.AbstractClient;

import java.util.ArrayList;

public abstract class AbstractTache {

    protected AbstractClient client;
    protected Integer codeT;
    protected String libelT;
    protected String descriptionT;
    protected Integer duree;
    protected ArrayList<AbstractLigneTache> listTache;

    public AbstractTache(Integer code,String des,AbstractClient client, String libelT, Integer duree) {
        this.client = client;
        this.descriptionT=des;
        this.libelT = libelT;
        this.duree = duree;
        this.codeT=code;
    }

    public AbstractClient getClient() {
        return client;
    }

    public void setClient(AbstractClient client) {
        this.client = client;
    }

    public Integer getCodeT() {
        return codeT;
    }

    public void setCodeT(Integer codeT) {
        this.codeT = codeT;
    }

    public String getLibelT() {
        return libelT;
    }

    public void setLibelT(String libelT) {
        this.libelT = libelT;
    }

    public String getDescriptionT() {
        return descriptionT;
    }

    public void setDescriptionT(String descriptionT) {
        this.descriptionT = descriptionT;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public ArrayList<AbstractLigneTache> getListTache() {
        return listTache;
    }

    public void setListTache(ArrayList<AbstractLigneTache> listTache) {
        this.listTache = listTache;
    }
}
