/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ETipoTreino;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTipoTreino;

/**
 *
 * @author Bruno
 */
public class NTipoTreino {
    
    PTipoTreino persistencia;
    
    public NTipoTreino(){
        
        persistencia = new PTipoTreino();
    }
    
    public void salvar (ETipoTreino parametro)throws SQLException{
        
        if(parametro.getCodigo_treino()== 0){
            
            persistencia.incluir(parametro);
        }
        else{
            
            persistencia.alterar(parametro);
        }
    }
    
    public void excluir (int parametro)throws SQLException{
        
        persistencia.excluir(parametro);
        
    }
    
    public ETipoTreino consultar(int parametro) throws SQLException{
        
        return persistencia.consultar(parametro);
    }
    
    public List<ETipoTreino> listar() throws SQLException{
        
        return persistencia.listar();
    }
}
