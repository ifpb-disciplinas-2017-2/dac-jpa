package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/02/2018, 08:58:54
 */
@Embeddable
public class TelefonePK implements Serializable {

    private String ddd;
    private String numero;

    public TelefonePK() {
    }

    public TelefonePK(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.ddd);
        hash = 17 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelefonePK other = (TelefonePK) obj;
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

}
