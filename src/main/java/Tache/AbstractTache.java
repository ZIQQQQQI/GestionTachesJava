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
}
