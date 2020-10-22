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

    public ArrayList<LigneTache> getLigneTache(String email){
        ArrayList<LigneTache> resultat =new ArrayList<>();
        int idc = 0;

        String sql1="select p.IdC from posseder p,intervenant i where i.NoSiret=p.NoSiret and i.MailI=?";
        List<Map<String,Object>> listC =template.queryForList(sql1,email);
        for(Map<String,Object>m :listC){
            idc=(Integer) m.get("IdC");
        }

        String sql2="select * from lignetache lt,competence c where lt.IdC=c.IdC and lt.EtatLT='proposee' and lt.IdC="+idc;
        List<Map<String,Object>> listLTP =template.queryForList(sql2);
        for(Map<String,Object>m :listLTP){
            idc=(Integer) m.get("IdC");
            String nomc=(String)m.get("NomC");
            Integer codelt =(Integer) m.get("CodeLT");
            Double prixlt = ((Float)m.get("PrixLT")).doubleValue();
            String etatlt=(String)m.get("EtatLT");
            Integer nbpersonne =(Integer)m.get("NbPers");
            String liblt=(String)m.get("LiblLT");

            resultat.add(new LigneTache(new Competence(nomc,idc),codelt,null,liblt,prixlt,etatlt,nbpersonne));
        }

        String sql3="select * from accepter a,intervenant i,lignetache lt, competence c where a.NoSiret=I.NoSiret and a.CodeLT=lt.CodeLT and lt.IdC=C.IdC and a.StatutAcc='acceptee'";
        List<Map<String,Object>> listLTA =template.queryForList(sql3);
        for(Map<String,Object>m :listLTA){
            idc=(Integer) m.get("IdC");
            String nomc=(String)m.get("NomC");
            Integer codelt =(Integer) m.get("CodeLT");
            Double prixlt = ((Float)m.get("PrixLT")).doubleValue();
            String etatlt=(String)m.get("EtatLT");
            Integer nbpersonne =(Integer)m.get("NbPers");
            String liblt=(String)m.get("LiblLT");

            resultat.add(new LigneTache(new Competence(nomc,idc),codelt,null,liblt,prixlt,etatlt,nbpersonne));
        }
        return resultat;

    }

}
