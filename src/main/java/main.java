<<<<<<< HEAD
public class main {

=======
import Compte.Client;

import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) {
        Client tang=new Client(1,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("tang","ziqi");

        Client si=new Client(2,"6 rue du 11 novembre","tangziqi1225@gmail.com","fr1111","ca1001","motdepasse");
        tang.personne("si","lu");

        System.out.println(tang.getIdE());
        System.out.println(si.getIdE());

    }
>>>>>>> a3b6741380d97106471cc0f0574821807cc5afca

}
