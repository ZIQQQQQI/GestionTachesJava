package Tache;

import Compte.AbstractIntervenant;

public abstract class AbstractMessage {

        protected String date;
        protected String contenu;

    public AbstractMessage() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public AbstractMessage(String date, String contenu) {
            this.date = date;
            this.contenu = contenu;
        }



}
