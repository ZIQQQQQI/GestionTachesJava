package Tache;

<<<<<<< HEAD
public class Tache extends AbstractTache{




=======
import Compte.AbstractClient;

public class Tache extends AbstractTache{

    public Tache(Integer id,String des,AbstractClient client, String libelT, Integer duree) {
        super(id,des,client, libelT, duree);
    }
>>>>>>> a3b6741380d97106471cc0f0574821807cc5afca




    //ajouter une ligne de tache dans listTache
    public void addTache(AbstractLigneTache tache){
        super.listTache.add(tache);
    }
<<<<<<< HEAD
=======



>>>>>>> a3b6741380d97106471cc0f0574821807cc5afca
}
