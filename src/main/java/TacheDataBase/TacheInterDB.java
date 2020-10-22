package TacheDataBase;

import Donnee.Competence;
import Tache.LigneTache;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TacheInterDB {
    private JdbcTemplate template;


    public TacheInterDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());
    }

    public ArrayList<LigneTache> getLigneTachePro(String email){
        ArrayList<LigneTache> ltPro =new ArrayList<>();
        int idc = 0;

        String sql1="select p.IdC from posseder p,intervenant i where i.NoSiret=p.NoSiret and i.MailI=?";
        List<Map<String,Object>> listC =template.queryForList(sql1,email);
        for(Map<String,Object>m :listC){
            idc=(Integer) m.get("IdC");
        }

        String sql2="Select * " +
                "From Intervenant, Posseder, LigneTache  ,competence c " +
                "Where LigneTache.IdC = Posseder.IdC " +
                "AND Posseder.IdC=c.IdC And  Intervenant.NoSiret = Posseder.NoSiret  " +
                "And LigneTache.EtatLT like 'proposee'  " +
                "And Intervenant.MailI = ?  " +
                "And Lignetache.codeLt not in ( Select codeLt " +
                " From Accepter " +
                "Where Accepter.statutAcc like 'refusee'  " +
                "And Accepter.NoSiret = Intervenant.NoSiret );";
        List<Map<String,Object>> listLTP =template.queryForList(sql2,email);
        for(Map<String,Object>m :listLTP){
            idc=(Integer) m.get("IdC");
            String nomc=(String)m.get("NomC");
            Integer codelt =(Integer) m.get("CodeLT");
            Double prixlt = ((Float)m.get("PrixLT")).doubleValue();
            String etatlt=(String)m.get("EtatLT");
            Integer nbpersonne =(Integer)m.get("NbPers");
            String liblt=(String)m.get("LiblLT");

            ltPro.add(new LigneTache(new Competence(nomc,idc),codelt,null,liblt,prixlt,etatlt,nbpersonne));
        }


        return ltPro;

    }

    public ArrayList<LigneTache> getLigneTacheAcp(String email){
        ArrayList<LigneTache> ltAcp =new ArrayList<>();

        String sql3="Select * From Accepter , LigneTache, Intervenant, Tache,competence C Where Accepter.CodeLt = LigneTache.codeLt And Accepter.NoSiret = Intervenant.NoSiret And LigneTache.codeT = Tache.codeT And Intervenant.MailI = ? And Accepter.StatutAcc like 'acceptee' AND C.IdC=lignetache.IdC";
        List<Map<String,Object>> listLTA =template.queryForList(sql3,email);
        for(Map<String,Object>m :listLTA){
            Integer idc=(Integer) m.get("IdC");
            String nomc=(String)m.get("NomC");
            Integer codelt =(Integer) m.get("CodeLT");
            Double prixlt = ((Float)m.get("PrixLT")).doubleValue();
            String etatlt=(String)m.get("EtatLT");
            Integer nbpersonne =(Integer)m.get("NbPers");
            String liblt=(String)m.get("LiblLT");

            ltAcp.add(new LigneTache(new Competence(nomc,idc),codelt,null,liblt,prixlt,etatlt,nbpersonne));
        }
        return ltAcp;
    }

}
