package Compte;

import Tache.AbstractMessage;

public class messageClient extends AbstractMessage {
    Client client;
    // Les méthodes de cette classes seront exactement les mêmes que celles que nous avons fait dans la
    // classe MessageIntervenant.
    //Elles doivent être utilisées dans le package DonneDataBase

    public messageClient(String date, String contenu,Client client) {
        super(date, contenu);
        this.client=client;
    }
}
