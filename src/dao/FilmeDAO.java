
package dao;
import beans.Filme;
 import java.sql.Connection;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class FilmeDAO {
  
    private Conexao conexao;
    private Connection conn;
    
    public FilmeDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Filme filme){
        String sql = "INSERT INTO filmes(nome,datalancamento,categoria) VALUES (?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            PreparedStatement  stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,filme.getNome());
            stmt.setString(2,sdf.format(filme.getDatalancamento()));
            stmt.setString(3,filme.getCategoria());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir filme: "+ e.getMessage());    
        }
        
    }
}
