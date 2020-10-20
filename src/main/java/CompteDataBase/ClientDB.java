package CompteDataBase;

import Compte.Client;
import Utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientDB {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    public Client login(Client loginClient){
        try {
            String sql="select IdClient,AdressC,MailC,IbanC,Bic,MdpC from client where MailC=? and MdpC=? ";
            Client client =template.queryForObject(sql,new BeanPropertyRowMapper<Client>(Client.class),loginClient.getMail(),loginClient.getMdp());
            return client;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;

        }

    }
}
