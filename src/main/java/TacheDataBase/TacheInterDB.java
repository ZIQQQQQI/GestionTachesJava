package TacheDataBase;

import Compte.Intervenant;
import CompteDataBase.IntervenantDB;
import Donnee.Competence;
import Tache.LigneTache;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TacheInterDB {
    private JdbcTemplate template;


    public TacheInterDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());
    }
    // Récupérer toutes les tâches proposées à un intervenant identifié par son mail
    // La requête permet de lui affecter toutes les tâches qui nécessitent la compétence de l'intervenant, et de ses disponibilités
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
        String sql2="Select distinct * From Intervenant, Posseder, Competence c," +
                "LigneTache Where LigneTache.IdC = Posseder.IdC " +
                "And Intervenant.NoSiret = Posseder.NoSiret and Posseder.IdC=c.IdC " +
                "And LigneTache.EtatLT like 'proposee' And Intervenant.MailI = ? And Lignetache.codeLt not in ( Select codeLt From Accepter Where Accepter.NoSiret = Intervenant.NoSiret ) " +
                "Group by Intervenant.IdI, intervenant.NoSiret, intervenant.RaisonSoc, intervenant.AdresseI, intervenant.IbanI, intervenant.BicI, intervenant.MailI, intervenant.MdpI" +
                ", intervenant.DateDebDispo, intervenant.DateFin, " +
                "intervenant.Profession, posseder.NoSiret, posseder.IdC," +
                " lignetache.CodeLT, lignetache.CodeT, lignetache.LiblLT," +
                " lignetache.LiblLT, lignetache.PrixLT, lignetache.NbPersLT, " +
                "lignetache.EtatLT, lignetache.IdC " ;
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

    // Obtenir la liste des tâches qui ont été accpeter par l'intervenant
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




    // Récupérer toutes les informations d'une tâche avec un identifiant de la ligne tache
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

    // Méthode pour changer l'état d'une tache  de "proposée" à "en cours" lorsque tous les intervenants l'ont accepté
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

      this.template.update(sqlAjoute,nosiret,idTache);String sqlV="Select lt.CodeLT as code From Lignetache lt, accepter a Where lt.CodeLT = a.CodeLT And a.StatutAcc = 'acceptee' Group by lt.CodeLT Having count(a.CodeLT) " +
                "= (select lt2.NbPersLT " +
                "From lignetache lt2 " +
                "Where lt2.Codelt = lt.Codelt)";
        Boolean v=false;
        for (Map<String,Object> m:this.template.queryForList(sqlV)
             ) {
            if(Integer.valueOf(idTache)==(Integer) m.get("code")) {
                v=true;
            }
        }
        if(v==true){
            String sqlUpdate="update lignetache set EtatLT= 'encours' where CodeLT=?";
            this.template.update(sqlUpdate,idTache);
        }



    }

    // Lorsqu'un intervenant termine une tache, on change son état à rendu
    public void terminerTache(String id){

        String sqlUpdate="update lignetache set EtatLT= 'rendue' where CodeLT=?";
        this.template.update(sqlUpdate,id);
    }

    // Récupérer le client qui a proposé la ligne de tache
    public Integer getidClient(String codelt){
        String sql="select t.IdClient from tache t,lignetache lt where lt.CodeT=t.CodeT and lt.Codelt=?";
        return (Integer) this.template.queryForList(sql,codelt).get(0).get("IdClient");
    }

    // Méthode pour insérer la note d'un client dans la BD
    public void noteClient(String idc,String nosiret,String noteR,String Notec){
        String sql="insert into notercli values(?,?,?,?)";
        this.template.update(sql,idc,nosiret,noteR,Notec);
    }


}
