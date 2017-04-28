/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ETipoTreino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class PTipoTreino {
    
    public void incluir(ETipoTreino parametro)throws SQLException{
        
       String sql = "INSERT INTO tipo_treino (descricao,nome_treino)"
               +"VALUES (?,?)";
       
       Connection cnn = util.Conexao.getconexao();
       PreparedStatement prd = cnn.prepareStatement(sql);
       
       prd.setString(1, parametro.getDescricao());
       prd.setString(2, parametro.getNome_treino());
       
       prd.execute();
       cnn.close();
               
    }
    
    public void alterar(ETipoTreino parametro)throws SQLException{
        
        String sql = "UPDATE tipo_treino SET descricao =?,nome_treino = ?"
                +"WHERE codigo_treino = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getDescricao());
        prd.setString(2, parametro.getNome_treino());
        
        prd.execute();
        cnn.close();
    }
    
    public void excluir(int codigo)throws SQLException{
        
        String sql = "DELETE FROM tipo_treino WHERE codigo_treino= ? ";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, codigo);
        
        prd.execute();
        cnn.close();
    }
    
    public ETipoTreino consultar(int codigo)throws SQLException{
        
        String sql = "SELECT * FROM tipo_treino WHERE codigo_treino = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1 , codigo);
        
        ResultSet rs = prd.executeQuery();
        
        ETipoTreino retorno = new ETipoTreino();
        
        if(rs.next()){
            retorno.setCodigo_treino(rs.getInt("codigo_treino"));
            retorno.setDescricao(rs.getString("descricao"));
            retorno.setNome_treino(rs.getString("nome_treino"));
        }
        rs.close();
        cnn.close();
        return retorno;
        
    }
    
    public List<ETipoTreino> listar()throws SQLException {
        
       List <ETipoTreino> lista = new ArrayList<>();
       
       String sql = "SELECT * FROM tipo_treino ORDER BY nome_treino";
       
       Connection cnn = util.Conexao.getconexao();
       Statement stm = cnn.createStatement();
        
       ResultSet rs = stm.executeQuery(sql);
       
      while(rs.next()) {
          ETipoTreino tipoTreino = new ETipoTreino();
          tipoTreino.setCodigo_treino(rs.getInt("codigo_treino"));
          tipoTreino.setDescricao(rs.getString("descricao"));
          tipoTreino.setNome_treino(rs.getString("nome_treino"));
          lista.add(tipoTreino);
      }
      
      rs.close();
      cnn.close();
      
      return lista;
    }
}
