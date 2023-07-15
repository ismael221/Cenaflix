/**
 * 
 * @author ismael221
 * @version 1.0
 * 
*/
package dao;
import beans.Filme;
 import java.sql.Connection;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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
    
    public List<Filme> getFilmesPorCategoria(String categoria){
          String sql = "SELECT * FROM filmes WHERE categoria LIKE ? "; 
            try {
          PreparedStatement stmt = this.conn.prepareStatement(sql);
                      
          stmt.setString(1,categoria);
          ResultSet rs = stmt.executeQuery();            
          
          List<Filme> listaFilmes = new ArrayList<>();     

          while (rs.next()) {
              Filme filme = new Filme();      
              filme.setId(rs.getInt("id"));
              filme.setNome(rs.getString("nome"));
              filme.setDatalancamento(rs.getDate("datalancamento"));
              filme.setCategoria(rs.getString("categoria"));
              //Adicionando os elementos na lista criada
              listaFilmes.add(filme);
          }

          return listaFilmes;
          

      } catch (Exception e) {
        System.out.println("Fime não encontrado");
          return null;
      }
    }
    
    public List<Filme> getFilmes(String nome){
         String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
         
         try{
         PreparedStatement stmt = this.conn.prepareStatement(sql);
         stmt.setString(1,nome);
         ResultSet rs = stmt.executeQuery();
         
                 
            List<Filme> listaFilmes = new ArrayList<>();
            
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setDatalancamento(rs.getDate("datalancamento"));
                filme.setCategoria(rs.getString("categoria"));
                
                listaFilmes.add(filme);    
            }
            return listaFilmes;
         }catch(Exception e){
             System.out.println("Não foi possivel localizar o filme");
             return null;
         }
     }
     
    public void editar (Filme filme){
       String sql = "UPDATE filmes SET  nome=?,datalancamento=?,categoria=? WHERE id =?";
       try {
          //esse trecho é igual ao método inserir
          PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
           ResultSet.CONCUR_UPDATABLE);
          //Setando os parâmetros
          stmt.setString(1, filme.getNome());
          try{
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
           stmt.setString(2, sdf.format(filme.getDatalancamento()));
          }catch(Exception e){
              System.out.println("Data inserida em um formato incorreto"+ e.getMessage());
              
          }
          stmt.setString(3, filme.getCategoria());
          stmt.setInt(4, filme.getId());
          //Executando a query
          stmt.execute();
          //tratando o erro, caso ele ocorra
      } catch (Exception e) {
          System.out.println("Erro ao editar filme verifique os dados digitados: " + e.getMessage());
      }
   }
    
    public void excluir(int id){
       String sql = "DELETE FROM filmes WHERE  id = ?";
          try {
          //esse trecho é igual ao método editar e inserir
          PreparedStatement stmt = this.conn.prepareStatement(sql);
          stmt.setInt(1, id);
          
          //Executando a query
          stmt.execute();
          //tratando o erro, caso ele ocorra
      } catch (Exception e) {
          System.out.println("Verifique se o campo ID corresponde a algum filme: " + e.getMessage());
      }
   }
   }

