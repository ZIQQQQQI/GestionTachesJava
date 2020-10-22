package CompteDataBase;

import Compte.Client;
import Compte.Intervenant;
import Utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntervenantDB {
    private JdbcTemplate template;

    public IntervenantDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());;
    }

    public Intervenant login(Intervenant intervenant){
        try {
            Intervenant res=null;
            String sql="select * from intervenant where MailI=? and MdpI=? ";
            List<Map<String, Object>> rows =template.queryForList(sql,intervenant.getMailI(),intervenant.getMdpI());
            for (Map<String,Object> m:rows) {
                Integer id=(Integer) m.get("IdI");
                String adress=(String) m.get("AdresseI");
                String mail=(String)m.get("MailI");
                Integer iban=(Integer) m.get("IbanI");
                Integer bic=(Integer) m.get("BicI");
                String mdp=(String)m.get("MdpI");
                Integer nosiret=(Integer) m.get("NoSiret");
                String nomE=(String)m.get("RaisonSoc");
                String debut=(String)m.get("DateDebDispo");
                String fin=(String)m.get("DateFin");
                res= new Intervenant(id,adress,mail,iban,bic,mdp,debut,fin);
                res.entrepreise(nomE,debut,fin,null);

            }
            return res;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;

        }

    }

    public void addIntervenant(Intervenant intervenant ) {
        String raison = intervenant.getNom();
        Integer siret = intervenant.getIdI();
        System.out.println("1"+raison);
        String mdp = intervenant.getMdpI();
        String adresse = intervenant.getAdresseI();
        Integer iban = intervenant.getIbanI();
        Integer bic = intervenant.getBicI();
        String mail = intervenant.getMailI();
        String debut = intervenant.getDateDebut();
        String fin = intervenant.getDateFin();
        String profession = intervenant.getProfession();
        String sql = "insert into intervenant (NoSiret,RaisonSoc,AdresseI,IbanI,BicI,MailI,MdpI" +
                ",DateDebDispo,DateFin,Profession) values(?,?,?,?,?,?,?,?,?,?)";
        int rows = this.template.update(sql, siret, raison, adresse, iban, bic, mail, mdp, debut, fin, profession);

    }

    public Intervenant newIntevenant(){

        String sql="select* from intervenant where IdI=(select max(IdI) from intervenant) ";
        List<Map<String,Object>> newClient=this.template.queryForList(sql);
        return this.sqlIntervenant(newClient);
    }
    //change comme mail idi
    public Intervenant unIntervenant(String idp){
        String sql="select* from intervenant where MailI=? ";
        List<Map<String,Object>> newInter=this.template.queryForList(sql,idp);
        return this.sqlIntervenant(newInter);
    }


    public  void updateIntevenant(Intervenant intervenant){

        String raison = intervenant.getNom();
        Integer siret = intervenant.getIdI();
        String mdp = intervenant.getMdpI();
        String adresse = intervenant.getAdresseI();
        Integer iban = intervenant.getIbanI();
        Integer bic = intervenant.getBicI();
        String mail = intervenant.getMailI();
        String debut = intervenant.getDateDebut();
        String fin = intervenant.getDateFin();
        String profession = intervenant.getProfession();
        String sql = "update intervenant set NoSiret=?,RaisonSoc=?,AdresseI=?,IbanI=?,BicI=?,MdpI=? " +
                ",DateDebDispo=?,DateFin=?,Profession=? where MailI=?";
       int rows= this.template.update(sql, siret, raison, adresse, iban, bic, mdp, debut, fin, profession, mail);

    }




    public  Intervenant sqlIntervenant( List<Map<String,Object>> newClient){
        Integer id= (Integer) newClient.get(0).get("NoSiret");
        String adresse=(String) newClient.get(0).get("AdresseI");
        String mail=(String) newClient.get(0).get("MailI");
        Integer iban= (Integer) newClient.get(0).get("IbanI");
        Integer bic= (Integer) newClient.get(0).get("BicI");
        String mdp= (String) newClient.get(0).get("MdpI");
        String nom =(String) newClient.get(0).get("RaisonSoc");
        String debut =(String) newClient.get(0).get("DateDebDispo");
        String fin =(String) newClient.get(0).get("DateFin");
        String profession=(String) newClient.get(0).get("Profession");
        Intervenant intervenant= new Intervenant(id,adresse,mail,iban,bic,mdp,debut,fin);
        intervenant.entrepreise(nom,debut,fin,profession);
        return intervenant;
    }








}
