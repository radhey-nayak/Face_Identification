
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConectaBanco {
    public Statement stm;
    public ResultSet rs;
    
    public Connection conn;
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String root ="jdbc:mysql://localhost:3306/facial_recognisation"; 
    private final String user ="root";
    private final String pass ="Paka";
            
            public void connect()
            {
                try{
                    System.setProperty("jdbc.Driver", driver);
                    conn = DriverManager.getConnection(root,user,pass);
                    System.out.println("ok!");
                } catch(SQLException e)
                {
                    System.out.println("Error :"+e);
                }
            }
            public void disconnect() 
            {
                try {
                    conn.close();
                }  catch(SQLException e)
                {
                    System.out.println("Error :"+e);
                }
                     
            }
            public void executeSQL(String SQL) 
            {
            try {
                stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stm.executeQuery(SQL);
                
            }  catch(SQLException e)
                {
                    System.out.println("Error :"+e);
                }
            }
           
}
