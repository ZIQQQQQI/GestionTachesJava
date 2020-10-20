import Compte.Client;
import Compte.Intervenant;
import Donnee.Competence;
import Donnee.DomaineCompetence;
import Tache.LigneTache;
import Tache.Tache;

import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) {
        Client tang=new Client(1,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("tang","ziqi");

        Client si=new Client(2,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("si","lu");
        Intervenant zhang=new Intervenant(1,"2 rue du capitole","zhang@12.com","1111253","fr1241212","zhangxingtian");

        DomaineCompetence dc1=new DomaineCompetence("informatique",1);
        Competence c1=new Competence("java",1);
        dc1.add(c1);

        Tache tacheJava=new Tache(1,"faire java",tang,"javaProjet",30);

        LigneTache lt1=new LigneTache(c1,1,tacheJava,"bd",25.2f,"proprose",2);

        zhang.accepterTache(lt1);


    }

}
