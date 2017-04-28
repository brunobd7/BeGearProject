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
public class EProfessores {
    
    private int codigo_professor;
    private String nome;
    private String cpf;
    private String certificado_cpr_aed;

    /**
     * @return the codigo_professor
     */
    public int getCodigo_professor() {
        return codigo_professor;
    }

    /**
     * @param codigo_professor the codigo_professor to set
     */
    public void setCodigo_professor(int codigo_professor) {
        this.codigo_professor = codigo_professor;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the certificado_cpr_aed
     */
    public String getCertificado_cpr_aed() {
        return certificado_cpr_aed;
    }

    /**
     * @param certificado_cpr_aed the certificado_cpr_aed to set
     */
    public void setCertificado_cpr_aed(String certificado_cpr_aed) {
        this.certificado_cpr_aed = certificado_cpr_aed;
    }
    
    
    
}
