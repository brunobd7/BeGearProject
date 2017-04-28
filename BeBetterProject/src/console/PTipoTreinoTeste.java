/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import entidade.ETipoTreino;
import java.sql.SQLException;
import persistencia.PTipoTreino;

/**
 *
 * @author Bruno
 */
public class PTipoTreinoTeste {
    
    public static void main(String[] args)throws SQLException{
        
        System.out.println("Testando a inclusão do tipo de treino");
        
        ETipoTreino tipoTreino = new ETipoTreino();
        tipoTreino.setDescricao("teste");
        tipoTreino.setNome_treino("treino teste");
       
        
        PTipoTreino persistencia = new PTipoTreino();
        persistencia.incluir(tipoTreino);
        
        if (tipoTreino.getCodigo_treino()!= 0) {
            System.out.println("Inclusão efetuada com sucesso!");
            
        }
        else {
            System.out.println("Aconteceu alguma treta");
        }
    }
    
}
