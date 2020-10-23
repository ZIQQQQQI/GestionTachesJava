package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
// Cette classe permet d'assurer une connexion avec la BD
public class JDBCUtils {
    private static DataSource ds;

    static{
        try {
            Properties pro =new Properties();
            // On récupère le nom et le mot de passe de la BD
            InputStream is=JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Permet d'accorder une connexion
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
