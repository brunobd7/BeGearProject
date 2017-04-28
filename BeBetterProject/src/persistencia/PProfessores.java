/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAluno;
import entidade.EProfessores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class PProfessores {
    
    public void incluir(EProfessores parametro)throws SQLException{
        
        String sql = "INSERT INTO professores (nome , cpf , certificado_cpr_aed)"
                + "VALUES (?,?,?)";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCpf());
        prd.setString(3, parametro.getCertificado_cpr_aed());
        
        prd.execute();
        cnn.close();
        
    }
    
    public void alterar(EProfessores parametro) throws SQLException{
        
        String sql = "UPDATE professores SET nome = ?, cpf = ?, "
                +"certificado_cpr_aed = ?"
                +"WHERE codigo_professor = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1 , parametro.getNome());
        prd.setString(2 , parametro.getCpf());
        prd.setString(3, parametro.getCertificado_cpr_aed());
        
        prd.execute();
        cnn.close();
    }
    
    public void excluir(int codigo) throws SQLException{
        
        String sql = "DELETE FROM professores WHERE codigo_professor = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1 , codigo);
        
        prd.execute();
        cnn.close();
        
    }
    
    public EProfessores consultar (int codigo) throws SQLException{
        
        String sql = "SELECT * FROM professores WHERE codigo_professor = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, codigo);
        
        ResultSet rs = prd.executeQuery();
        
        EProfessores eProfessor = new EProfessores();
        
        while(rs.next()){
            eProfessor.setNome(rs.getString("nome"));
            eProfessor.setCpf(rs.getString("cpf"));
            eProfessor.setCertificado_cpr_aed(rs.getString("certificado_cpr_aed"));
        }
        rs.close();
        cnn.close();
        
        return eProfessor;
    }
    
    public List<EProfessores> listar (String nome) throws SQLException{
        List<EProfessores> lista = new ArrayList<>();
        
        Connection cnn = util.Conexao.getconexao();
        
        String sql = "SELECT * "
                + "FROM professores "
                + "WHERE 1=1 ";

        if (nome != null) {
            if (!nome.isEmpty()) {
                sql += " and nome like ? ";
            }
        }

        sql += "ORDER BY nome";

        PreparedStatement prd = cnn.prepareStatement(sql);

        if (nome != null) {
            if (!nome.isEmpty()) {
                prd.setString(1, "%" + nome + "%");
            }
        }
        
        ResultSet rs = prd.executeQuery();
        EProfessores professor = new EProfessores();
        while(rs.next()){
            
            professor.setCodigo_professor(rs.getInt("codigo_professor"));
            professor.setNome(rs.getString("nome"));
            professor.setCpf(rs.getString("cpf"));
            professor.setCertificado_cpr_aed(rs.getString("certificado_cpr_aed"));
            lista.add(professor);
        }
        rs.close();
        cnn.close();
        return lista;
        
        
    }
            
}
