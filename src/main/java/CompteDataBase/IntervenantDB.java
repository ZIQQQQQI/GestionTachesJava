package CompteDataBase;

import Compte.Intervenant;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class IntervenantDB {
    private JdbcTemplate template;

    public IntervenantDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());;
    }

    public void addIntervenant(Intervenant intervenant ){
       String raison=intervenant.getNom();
       Integer siret=intervenant.getIdI();
       String mdp=intervenant.getMdpI();
       String adresse=intervenant.getAdresseI();
       Integer iban=intervenant.getIbanI();
       Integer bic=intervenant.getBicI();
       String mail=intervenant.getMailI();
       String debut=intervenant.getDateDebut();
       String fin=intervenant.getDateFin();
       String profession=intervenant.getProfession();
       String sql="insert into intervenant (NoSiret,RaisonSoc,AdresseI,IbanI,BicI,MailI,MdpI" +
               ",DateDebDispo,DateFin,Profession) values(?,?,?,?,?,?,?,?,?,?)";
        int rows = this.template.update(sql,siret,raison,adresse,iban,bic,mail,mdp,debut,fin,profession);
        System.out.println(rows);





    }
}
