/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EProfessores;
import java.sql.SQLException;
import java.util.List;
import persistencia.PProfessores;

/**
 *
 * @author Bruno
 */
public class NProfessores {
    
    PProfessores persistencia;
    
    public NProfessores(){
        persistencia = new PProfessores();
    }
    
    public void salvar (EProfessores parametro) throws SQLException{
        
        if(parametro.getCodigo_professor()== 0){
            
            persistencia.incluir(parametro);
        }
        else{
            
            persistencia.alterar(parametro);
        }
    }
    
    public void excluir (int parametro) throws SQLException{
        
        persistencia.excluir(parametro);
    }
    
    public EProfessores consultar(int parametro) throws SQLException{
        
        return persistencia.consultar(parametro);
    }
    
    public List<EProfessores> listar (String nome) throws SQLException{
        
        return persistencia.listar(nome);
    }
}
