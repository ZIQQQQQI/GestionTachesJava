package Compte;

import Tache.AbstractMessage;

public class MessageIntervenant extends AbstractMessage {
<<<<<<< HEAD
    private Intervenant expediteur;

    public MessageIntervenant(String date, String contenu, Intervenant i) {
        super(date, contenu);
        this.expediteur = i;
=======
    Intervenant intervenant;
    public MessageIntervenant(String date, String contenu,Intervenant intervenant) {
        super(date, contenu);
        this.intervenant=intervenant;
>>>>>>> 437d908a5b86e22e49032a32e38cb739a7d6b4c5
    }
}
