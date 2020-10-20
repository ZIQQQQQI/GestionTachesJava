package Compte;

import Tache.AbstractMessage;

public class MessageIntervenant extends AbstractMessage {
    private Intervenant expediteur;

    public MessageIntervenant(String date, String contenu, Intervenant i) {
        super(date, contenu);
        this.expediteur = i;
    }
}
