package Tache;

import Compte.AbstractClient;

import java.util.ArrayList;

public abstract class AbstractTache {
    protected AbstractClient client;
    protected Integer codeT;
    protected String libelT;
    protected String descriptionT;
    protected Integer duree;
    protected ArrayList<AbstractLigneTache> listTahce;


}
