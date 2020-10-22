package TacheDataBase;

import Compte.Intervenant;
import CompteDataBase.IntervenantDB;
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
        //pas utile
        String sql1="select p.IdC from posseder p,intervenant i where i.NoSiret=p.NoSiret and i.MailI=?";
        List<Map<String,Object>> listC =template.queryForList(sql1,email);
        for(Map<String,Object>m :listC){
            idc=(Integer) m.get("IdC");
        }
        //sql utile
        String sql2="Select distinct * " +
                "From Intervenant, Posseder, LigneTache  ,competence c " +
                "Where LigneTache.IdC = Posseder.IdC " +
                "AND Posseder.IdC=c.IdC And  Intervenant.NoSiret = Posseder.NoSiret  " +
                "And LigneTache.EtatLT like 'proposee'  " +
                "And Intervenant.MailI = ?  " +
                "And Lignetache.codeLt not in ( Select codeLt " +
                " From Accepter " +
                "Where Accepter.NoSiret = Intervenant.NoSiret );";
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





    public List<Map<String,Object>> unTache(String id){
        String sql="Select LigneTache.EtatLT AS etat,LigneTache.liblLt, Tache.DureeT, LigneTache.nbPersLT, Tache.DescriptionT, Tache.IdClient, Tache.LiblT, t1.noteC,  t1.noteR, t1.NomC, t1.PrenomC ,lignetache.PrixLT,lignetache.NbPersLT " +
                "From LigneTache, Tache, (Select Client.IdClient, Client.NomC, " +
                "Client.PrenomC, AVG(NoterCli.noteclirent) as noteR, AVG(Notercli.noteCliCom) as noteC " +
                "From  Client, NoterCli " +
                "Where Client.IdClient = Notercli.IdClient " +
                "Group by Client.IdClient, Client.NomC, Client.PrenomC)  t1 " +
                "Where Tache.codeT = LigneTache.codeT And Tache.IdClient = t1.IdClient " +
                "And LigneTache.codeLT = ?" ;
        return this.template.queryForList(sql,id);
    }

    public void accepterTache(String mailI,String idTache,Boolean accepter){

        IntervenantDB db=new IntervenantDB();
        Intervenant lui=db.unIntervenant(mailI);
        Integer nosiret=lui.getIdI();
        String sqlAjoute;
        if(accepter==true){
            sqlAjoute="insert into accepter ( NoSiret, CodeLT, StatutAcc) values ( ?, ?, 'acceptee')";
        }else {
            sqlAjoute=  " insert into accepter ( NoSiret, CodeLT, StatutAcc) values ( ?, ?, 'refusee')";
        }



      this.template.update(sqlAjoute,nosiret,idTache);

        String sqlUpdate="update lignetache set EtatLT= 'encours' where CodeLT=?";
        this.template.update(sqlUpdate,idTache);


    }
    public void terminerTache(String id){
        String sqlUpdate="update lignetache set EtatLT= 'terminee' where CodeLT=?";
        this.template.update(sqlUpdate,id);
    }

    public Integer getidClient(String codelt){
        String sql="select t.IdClient from tache t,lignetache lt where lt.CodeT=t.CodeT and lt.Codelt=?";
        return (Integer) this.template.queryForList(sql,codelt).get(0).get("IdClient");
    }

    public void noteClient(String idc,String nosiret,String noteR,String Notec){
        String sql="insert into notercli values(?,?,?,?)";
        this.template.update(sql,idc,nosiret,noteR,Notec);
    }


}
