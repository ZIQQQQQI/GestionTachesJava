import Compte.AbstractIntervenant;
import Compte.Client;
import Compte.Intervenant;
import Donnee.Competence;
import Donnee.DomaineCompetence;
import Tache.LigneTache;
import Tache.Tache;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        //ajouter un client
        Client tang=new Client(1,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("tang","ziqi");

        Client si=new Client(2,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("si","lu");
        //ajouter un intervenant
        Intervenant zhang=new Intervenant(1,"2 rue du capitole","zhang@12.com","1111253","fr1241212","zhangxingtian");
        //enregistre des informations entreprise
        zhang.entrepreise("zhang banque","01-01-2011",null,"informatique");
        //ajouter une domaine
        DomaineCompetence dc1=new DomaineCompetence("informatique",1);
        Competence c1=new Competence("java",1);
        dc1.add(c1);
        //ajoter une competence pour un intervenant
        zhang.addCompetence(c1);

        //creer une tache
        Tache tacheJava=new Tache(1,"faire java",tang,"javaProjet",30);


        //creer une ligne de tache
        LigneTache lt1=new LigneTache(c1,1,tacheJava,"bd",25.2f,"proprose",2);
        //un intervenant accpter une tache
        zhang.accepterTache(lt1);
        //trouve des intervenant qui a accpte une tache
        ArrayList<AbstractIntervenant> liste=lt1.getAccepte();

        for(AbstractIntervenant i:liste){
            System.out.println(((Intervenant)i).getNom());
        }



    }

}
