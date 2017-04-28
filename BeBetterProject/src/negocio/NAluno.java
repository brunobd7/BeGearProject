/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EAluno;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAluno;

/**
 *
 * @author Bruno
 */
public class NAluno {
    
    PAluno persistencia;
    
    public NAluno(){
        
       persistencia = new PAluno();
    }
    
    public void salvar (EAluno parametro) throws SQLException{
         
        if(parametro.getCodigo_aluno()==0){
            persistencia.incluir(parametro);
        }
        else {
            persistencia.alterar(parametro);
        }
    } 
    
    public void excluir (int parametro) throws SQLException{
        
        persistencia.excluir(parametro);
    }
    
    public EAluno consultar(int parametro) throws SQLException{
       
        return persistencia.consultar(parametro);
    }
    
    public List<EAluno> listar(String nome) throws SQLException{
        
        return persistencia.listar(nome);
    }
}
