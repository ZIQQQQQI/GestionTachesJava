package Compte;

import Tache.AbstractMessage;

public class MessageIntervenant extends AbstractMessage {
    Intervenant intervenant;
    public MessageIntervenant(String date, String contenu,Intervenant intervenant) {
        super(date, contenu);
        this.intervenant=intervenant;
    }
}
