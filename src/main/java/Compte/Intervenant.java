package Compte;

import Reclamation.AbstractReclamation;
import Tache.AbstractLigneTache;

import java.util.ArrayList;

public class Intervenant extends AbstractIntervenant {
    private ArrayList<AbstractLigneTache> tachesProposees = new ArrayList<>();


    public void envoyerMessageReclamation(MessageIntervenant msg, AbstractReclamation r){
        AbstractReclamation.addMessage(msg);
    }

    public void accepterTache(AbstractLigneTache lt){
        tachesProposees.indexOf(lt).setEtat(enCours);
    }

    public void refuserTache(AbstractLigneTache lt){
        tachesProposees.indexOf(lt).setEtat(refusée);
    }
}
