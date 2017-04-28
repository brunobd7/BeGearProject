/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Heuber
 */
public class ComboItem
{
    private String descricao;
    private String codigo_treino;

    public ComboItem(String descricao, String codigo_treino)
    {
        this.descricao = descricao;
        this.codigo_treino = codigo_treino;
    }

    @Override
    public String toString()
    {
        return descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public String getCodigo_treino()
    {
        return codigo_treino;
    }
}
