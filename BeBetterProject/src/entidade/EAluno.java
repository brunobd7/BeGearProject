/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Bruno
 */
public class EAluno {
    
    private int codigo_aluno;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private ETipoTreino codigo_tipo_treino;
    private double imc;
    private String sexo_aluno;
    private String bio_tipo;
    
    public EAluno (){
        codigo_tipo_treino = new ETipoTreino();
    }

    /**
     * @return the codigo_aluno
     */
    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    /**
     * @param codigo_aluno the codigo_aluno to set
     */
    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the imc
     */
    public double getImc() {
        return imc;
    }

    /**
     * @param imc the imc to set
     */
    public void setImc(double imc) {
        this.imc = imc;
    }

    /**
     * @return the sexo_aluno
     */
    public String getSexo_aluno() {
        return sexo_aluno;
    }

    /**
     * @param sexo_aluno the sexo_aluno to set
     */
    public void setSexo_aluno(String sexo_aluno) {
        this.sexo_aluno = sexo_aluno;
    }

    /**
     * @return the bio_tipo
     */
    public String getBio_tipo() {
        return bio_tipo;
    }

    /**
     * @param bio_tipo the bio_tipo to set
     */
    public void setBio_tipo(String bio_tipo) {
        this.bio_tipo = bio_tipo;
    }

    /**
     * @return the codigo_tipo_treino
     */
    public ETipoTreino getCodigo_tipo_treino() {
        return codigo_tipo_treino;
    }

    /**
     * @param codigo_tipo_treino the codigo_tipo_treino to set
     */
    public void setETipoTreino(ETipoTreino codigo_tipo_treino) {
        this.codigo_tipo_treino = codigo_tipo_treino;
    }
    
   
}
