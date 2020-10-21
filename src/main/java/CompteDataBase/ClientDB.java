package CompteDataBase;

import Compte.Client;
import Utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ClientDB {
    private JdbcTemplate template;

    public ClientDB() {
        this.template =new JdbcTemplate(JDBCUtils.getDataSource());;
    }


    public Client login(Client loginClient){
        try {
            Client client=null;
            String sql="select * from client where MailC=? and MdpC=? ";
            List<Map<String, Object>> rows =template.queryForList(sql,loginClient.getMail(),loginClient.getMdp());
            for (Map<String,Object> m:rows) {
                Integer id=(Integer) m.get("IdClient");
                String adress=(String) m.get("AdresseC");
                String mail=(String)m.get("MailC");
                Integer iban=(Integer) m.get("IbanC");
                Integer bic=(Integer) m.get("BicC");
                String mdp=(String)m.get("MdpC");

                String nosiret=(String) m.get("NoSiret");
                String nomE=(String)m.get("NomE");
                client= new Client(id,adress,mail,iban,bic,mdp);

            }
            return client;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;

        }

    }


    public void ajouterClient(Client client){

        String adresse=client.getAdresse();
        String mail=client.getMail();
        Integer bic=client.getBic();
        Integer iban=client.getIban();
        String mdp=client.getMdp();
        String sql="insert into client (AdresseC,MailC,IbanC,BicC,MdpC) values(?,?,?,?,?) ";
        int rows = this.template.update(sql,adresse,mail,iban,bic,mdp);
        System.out.println(rows);
    }



}
