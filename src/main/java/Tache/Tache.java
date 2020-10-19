package Tache;

import Compte.AbstractClient;

public class Tache extends AbstractTache{

    public Tache(Integer id,String des,AbstractClient client, String libelT, Integer duree) {
        super(id,des,client, libelT, duree);
    }

    //ajouter une ligne de tache dans listTache
    public void addTache(AbstractLigneTache tache){
        super.listTache.add(tache);
    }



}
