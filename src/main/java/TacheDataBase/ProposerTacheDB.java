package TacheDataBase;

import Tache.Tache;
import Utils.JDBCUtils;
import Tache.LigneTache;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ProposerTacheDB {
    private JdbcTemplate template;


    public ProposerTacheDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());
    }

    // Méthode pour crée une nouvelle tache
    public void ajouterTache(Tache t){
        String sql="insert into tache (LiblT,DescriptionT,DureeT,IdClient,EtatT) values(?,?,?,1,?)";

        String nomtache=t.getLibelT();
        String description=t.getDescriptionT();
        Integer duree=t.getDuree();
        String etat="proposee";

        template.update(sql,nomtache,description,duree,etat);
    }

    // Créer une ligne de tache pour la dernière tache crée
    public void ajouterligneTache(ArrayList<LigneTache> listLT){
        String sql="select max(CodeT) as id from tache";
        Integer codeT=(Integer)template.queryForList(sql).get(0).get("id");
        String sql1="insert into lignetache (CodeT,LiblLT,PrixLT,NbPersLT,EtatLT,IdC) values(?,?,?,?,?,?)";
        for(LigneTache lt:listLT){
            String libllt=lt.getLibLT();
            Float prixlt=lt.getPrixLT().floatValue();
            Integer nbper=lt.getNbPersonne();
            String etat="proposee";
            Integer idc=lt.getCompetence().getIdC();
            template.update(sql1,codeT,libllt,prixlt,nbper,etat,idc);
        }
    }
}