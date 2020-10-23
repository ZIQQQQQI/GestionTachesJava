package TacheDataBase;

import Tache.LigneTache;
import Tache.Tache;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TacheClientDB {
    private JdbcTemplate template;


    public TacheClientDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());
    }
 // Ce scénario n'a pas été utilisé dans l'interface;
    // mais permet d'afficher toutes les tâches qu'un client à proposé

    public ArrayList<LigneTache> getLigneTache(String email){
        ArrayList<LigneTache> resultat =new ArrayList<>();
        String sql="select * from tache t,lignetache lt,client c where lt.CodeT=t.CodeT and c.IdClient=t.IdClient and c.MailC=?";
        List<Map<String,Object>> list = template.queryForList(sql,email);

        for(Map<String,Object> m:list){
            Integer codelt =(Integer) m.get("CodeLT");
            Double prixlt = ((Float)m.get("PrixLT")).doubleValue();
            String etatlt=(String)m.get("EtatLT");
            //Integer nbpersonne =(Integer)m.get("NbPers");
            String liblt=(String)m.get("LiblLT");

            resultat.add(new LigneTache(null,codelt,null,liblt,prixlt,etatlt,null));
        }


        return resultat;
    }
}
