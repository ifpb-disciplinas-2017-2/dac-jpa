package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2018, 09:01:12
 */
@Embeddable
public class Endereco implements Serializable {

//    @Transient
    private String rua;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
