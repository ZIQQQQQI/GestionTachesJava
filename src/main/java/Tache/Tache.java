package Tache;

import Compte.AbstractClient;

import java.util.ArrayList;

public class Tache extends AbstractTache{


    public Tache(Integer id,String des,AbstractClient client, String libelT, Integer duree) {
        super(id,des,client, libelT, duree);
        super.listTache= new ArrayList<AbstractLigneTache>();
    }

    //ajouter une ligne de tache dans listTache
    public void addTache(AbstractLigneTache tache){
        super.listTache.add(tache);
    }



}
