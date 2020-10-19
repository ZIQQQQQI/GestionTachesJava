package Reclamation;

import Compte.AbstractClient;
import Compte.AbstractIntervenant;
import Donnee.AbstractServiceClient;
import Tache.AbstractMessage;
import Tache.AbstractTache;

import java.util.ArrayList;

public abstract class AbstractReclamation {
    protected String description;
    protected AbstractTache tache;
    protected AbstractClient client;
    protected AbstractIntervenant intervenant;
    protected AbstractServiceClient serviceClient;
    protected ArrayList<AbstractMessage> listMessage;


    public AbstractReclamation( AbstractTache tache) {
        this.listMessage=new ArrayList<>();
        this.tache = tache;
    }


}
