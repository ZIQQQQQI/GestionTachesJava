import Compte.AbstractIntervenant;
import Compte.Client;
import Compte.Intervenant;
import CompteDataBase.ClientDB;
import CompteDataBase.IntervenantDB;
import Donnee.Competence;
import Donnee.DomaineCompetence;
import Tache.LigneTache;
import Tache.Tache;
import Utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {

        //ajouter un client
        Client tang=new Client(1,"6 rue du 11 novembre","tangziqi1225@gmail.com",111,3213123,"motdepasse");
        tang.personne("tang","ziqi");

        Client si=new Client(2,"6 rue du 11 novembre","tangziqi1225@gmail.com",222,1234,"motdepasse");
        tang.personne("si","lu");
        //ajouter un intervenant
        Intervenant zhang=new Intervenant(1,"2 rue du capitole","zhang@12.com",1111253,1241212,"zhangxingtian","01/01/2020","01-05/2021");
        //enregistre des informations entreprise
        zhang.entrepreise("zhang banque","01-01-2011",null,"informaticien");
        //ajouter une domaine
        DomaineCompetence dc1=new DomaineCompetence("informatique",1);
        Competence c1, c2, c3;
        c1=new Competence("java",1);
        c2= new Competence("UML", 2);
        c3= new Competence("PHP", 3);
        dc1.add(c1);
        dc1.add(c2);
        dc1.add(c3);
        //ajouter une competence pour un intervenant
        zhang.addCompetence(c1);
        zhang.addCompetence(c2);

        //Le client Tang créer une tache
        Tache t;
        t = tang.proposeTache(1, "Créer une plateforme de micro-tasking", "JavaProjet", 30);
        //Le client décompose sa tâche en ligne de tache
       // LigneTache lt1, lt2;

        // Tache tacheJava=new Tache(1,"faire java",tang,"javaProjet",30);
        //creer une ligne de tache
        //LigneTache lt1=new LigneTache(c1,1,tacheJava,"bd",25.2f,"proprose",2);

        //L'intervenant Zhang accepte une tache
         //zhang.accepterTache(lt1);
         //L'intervenant Zhang refuse une tache
        //zhang.refuseTache(lt2);
        // zhang.envoyerMessageTache("Bonjour, pouvez-vous détailler votre besoin", lt1);




        //trouve des intervenants qui a accpte une tache
        //ArrayList<AbstractIntervenant> liste=lt1.getAccepte();

       /* for(AbstractIntervenant i:liste){
            System.out.println(((Intervenant)i).getNom());
        }*/


        IntervenantDB i=new IntervenantDB();
        i.addIntervenant(zhang);

        






    }

}
