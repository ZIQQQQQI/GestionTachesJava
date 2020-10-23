package Compte;

import Tache.AbstractMessage;

public class MessageIntervenant extends AbstractMessage {
    Intervenant intervenant;
    //Ces méthodes seront utilisées dans le package DonneeDataBase
    public MessageIntervenant(String date, String contenu) {
        super(date, contenu);
    }

    public MessageIntervenant(String date, String contenu, Intervenant intervenant) {
        super(date, contenu);
        this.intervenant=intervenant;
    }
}
