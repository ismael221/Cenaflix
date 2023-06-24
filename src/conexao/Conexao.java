package conexao;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    Connection conn;
    
    public Connection getConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix","root","ismael");
           return conn;
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi posssivel conectar: "+ex.getMessage());
            return null;
        }
    }
    public void desconectar(Connection conn){
       try{
           if(conn != null && !conn.isClosed()){
               conn.close();
               System.out.println("Desconectado do banco de dados");
           }
       }catch(SQLException  ex){
           System.out.println("Não foi possivel desconectar do banco de dados "+ex.getMessage());
       }
    }
    
}
