package Tache;

import Compte.AbstractIntervenant;

public abstract class AbstractMessage {

        protected String date;
        protected String contenu;


        public AbstractMessage(String date, String contenu) {
            this.date = date;
            this.contenu = contenu;
        }



}
