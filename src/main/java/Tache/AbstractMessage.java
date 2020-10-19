package Tache;

public class AbstractMessage {

        protected String date;
        protected String contenu;
        protected String expediteur;

        public AbstractMessage(String date, String contenu) {
            this.date = date;
            this.contenu = contenu;
        }

}
