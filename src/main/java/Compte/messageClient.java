package Compte;

import Tache.AbstractMessage;

public class messageClient extends AbstractMessage {
    Client client;
    public messageClient(String date, String contenu,Client client) {
        super(date, contenu);
        this.client=client;
    }
}
