package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2018, 09:08:38
 */
@Embeddable
public class CPF implements Serializable {

    private String numero;
    @Transient
    private boolean valido;

    public CPF() {
    }

    public CPF(String numero) { // 12312312331
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean bemFormatado() {
        return true;
    }

    public String formatado() {
        return "123.123.123-31";
    }

}
