/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAluno;
import entidade.ETipoTreino;
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
public class PAluno {
    
    public void incluir (EAluno parametro) throws SQLException {
        
       String sql = "INSERT INTO alunos(nome,idade,peso,altura,codigo_tipo_treino,imc,sexo_aluno,bio_tipo)"
               +"VALUES (?,?,?,?,?,?,?,?)";
       
       Connection cnn = util.Conexao.getconexao();
       
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getNome());
        prd.setInt(2, parametro.getIdade());
        prd.setDouble(3, parametro.getPeso());
        prd.setDouble(4, parametro.getAltura());
        prd.setInt(5 , parametro.getCodigo_tipo_treino().getCodigo_treino());
        prd.setDouble(6, parametro.getImc());
        prd.setString(7, parametro.getSexo_aluno());
        prd.setString(8, parametro.getBio_tipo());
        
        prd.execute();
        cnn.close();
        
    }
    
    public void alterar(EAluno parametro)throws SQLException{
        
        String sql = "UPDATE alunos SET nome = ?, "
                +"idade = ?,"
                +"peso = ?,"
                +"altura = ?,"
                +"codigo_tipo_treino = ?,"
                +"imc = ?,"
                +"sexo_aluno = ?,"
                +"bio_tipo = ?"
                +"WHERE codigo_aluno = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getNome());
        prd.setInt(2, parametro.getIdade());
        prd.setDouble(3, parametro.getPeso());
        prd.setDouble(4, parametro.getAltura());
        prd.setInt(5 , parametro.getCodigo_tipo_treino().getCodigo_treino());
        prd.setDouble(6, parametro.getImc());
        prd.setString(7, parametro.getSexo_aluno());
        prd.setString(8, parametro.getBio_tipo());
        
        prd.execute();
        cnn.close();
    }
    
    public void excluir (int codigo)throws SQLException{
        
        String sql = "DELETE FROM alunos WHERE codigo_aluno = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, codigo);
        
        prd.execute();
        cnn.close();
    }
    
    public EAluno consultar(int codigo)throws SQLException{
        
        String sql = "SELECT * FROM alunos WHERE codigo_aluno = ?";
        
        Connection cnn = util.Conexao.getconexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, codigo);
        
        ResultSet rs = prd.executeQuery();
        
        ETipoTreino eTipoTreino = new ETipoTreino();
        PTipoTreino pTipoTreino = new PTipoTreino();
        
        EAluno eAluno = new EAluno(); 
        
        if (rs.next()) {
            eTipoTreino = pTipoTreino.consultar(rs.getInt("codigo_tipo_treino"));
            eAluno.setCodigo_aluno(rs.getInt("codigo_aluno"));
            eAluno.setNome(rs.getString("nome"));
            eAluno.setIdade(rs.getInt("idade"));
            eAluno.setPeso(rs.getDouble("peso"));
            eAluno.setAltura(rs.getDouble("altura"));
            eAluno.setImc(rs.getDouble("imc"));
            eAluno.setSexo_aluno(rs.getString("sexo_aluno"));
            eAluno.setBio_tipo(rs.getString("bio_tipo"));
            eAluno.setETipoTreino(eTipoTreino);

        }
        
        rs.close();
        cnn.close();
        
        return eAluno;
        
    }
    
    public List<EAluno> listar(String nome )throws SQLException{
         
        List<EAluno> lista = new ArrayList<>();
        
        Connection cnn = util.Conexao.getconexao();
        
        String sql = "SELECT * "
                + "FROM alunos "
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
        
        while (rs.next()){
            EAluno aluno = new EAluno();
            aluno.setCodigo_aluno(rs.getInt("codigo_aluno"));
            aluno.setNome(rs.getString("nome"));
            aluno.setIdade(rs.getInt("idade"));
            aluno.setPeso(rs.getDouble("peso"));
            aluno.setAltura(rs.getDouble("altura"));
            aluno.setImc(rs.getDouble("imc"));
            aluno.setSexo_aluno(rs.getString("sexo_aluno"));
            aluno.setBio_tipo(rs.getString("bio_tipo"));
            lista.add(aluno);
        }
        
        rs.close();
        cnn.close();
        return lista;
    }
}

