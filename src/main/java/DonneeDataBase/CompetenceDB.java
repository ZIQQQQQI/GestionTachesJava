package DonneeDataBase;

import Compte.Intervenant;
import Donnee.Competence;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompetenceDB {

    private JdbcTemplate template;

    public CompetenceDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());;
    }

    public void ajouterCompetenceIntervenant(Integer idC,Integer idI){
        String sql="insert into posseder (IdI,IdC) values(?,?) ";
       this.template.update(sql,idI,idC);


    }

    public Competence competenceInter(Intervenant i){
        String sql="select* from posseder p,competence c where c.IdC=p.IdC and p.IdI=?";
        List<Map<String,Object>> list=this.template.queryForList(sql,i.getIdI());
        String nom=(String)list.get(0).get("NomC");
        Integer id=(Integer) list.get(0).get("IdC");
        return new Competence(nom,id);
    }

    public ArrayList<Competence> tousCom(){
        ArrayList<Competence> Result=new ArrayList<>();
        String sql="select* from competence";
        List<Map<String,Object>> list=this.template.queryForList(sql);
        for (Map<String,Object> m:list
             ) {
            String nom=(String) m.get("NomC");
            Integer id=(Integer) m.get("IdC");
            Result.add(new Competence(nom,id));
        }

        return Result;
    }

    public void updateIne(Integer idc,Integer idI){
        String sql="update posseder set IdC=? where IdI=?";
        this.template.update(sql,idc,idI);

    }


}
