package DonneeDataBase;

import Compte.MessageIntervenant;
import Utils.JDBCUtils;
import com.mysql.cj.protocol.Message;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MessageDB {

    private JdbcTemplate template;
    // Connexion avec la BD
    public MessageDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());;
    }
    // Cette méthode permet de récuperer tout les méssages échanger pour une ligne de tache
    // à l'aide d'une requête

    public  List<Map<String,Object>> tousMsg(String idTache){
        ArrayList<MessageIntervenant> res=new ArrayList<>();
        String sql="Select t1.contenuemsg, t1.dateMsg, t1.Nom " +
                "    From (Select m.contenuemsg, m.dateMsg, cli.PrenomC as Nom, lt.codeLt ,m.IdMsg as id" +
                "                    From Message m, envoyermsg c, client cli, lignetache lt " +
                "    Where m.IdMsg = c.IdMsg " +
                "                  and c.IdClient = cli.IdClient " +
                "                  And c.codeLt = lt.codeLt " +
                "                  UNION " +
                "                  SELECT m2.contenuemsg, m2.dateMsg, inter.RaisonSoc, lt2.codeLt,M2.IdMsg as id " +
                "                  FROM message M2, intervenant inter, envoyermsginter i, lignetache lt2 " +
                "    Where m2.IdMsg = i.IdMsg " +
                "                  and i.NoSiret = inter.NoSiret " +
                "                  And i.codeLt = lt2.codeLt ) t1 " +
                "    Where t1.codeLt = ? " +
                "    Order by t1.id ASC;";
        return this.template.queryForList(sql,idTache);


    }

    //Méthode permettant de retrouver le dernier message
    public Integer dernierMessage(){
        String sql="select max(IdMsg) as id from message  ";
        return (Integer) this.template.queryForList(sql).get(0).get("id");
    };

    //Méthode permettant d'envoyer un message par un intervenant,
    // donc d'insérer une nouveau message dans la BD
    public void envoyerMsgInter(String contenu,String nosiret,String codeLT){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
        String date = sdf.format(new Date());
        String sql="insert into message (DateMsg,contenueMsg) values (?,?)";
        this.template.update(sql,new Object[]{date,contenu});
        // On associe le dernier message envoyé avec son expéditeur et la ligne de tache
        String sql2="insert into envoyermsginter (NoSiret,IdMsg,CodeLT) values (?,?,?)";
        this.template.update(sql2,nosiret,this.dernierMessage(),codeLT);

    }

}
