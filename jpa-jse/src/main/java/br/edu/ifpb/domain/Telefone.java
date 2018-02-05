package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/02/2018, 08:49:17
 */
@Entity
@IdClass(TelefoneChave.class)
public class Telefone implements Serializable {

//    @Column(unique = true)
    private String codigoDoPais = "+55";
    @Id
    private String ddd;
    @Id
    private String numero;
//    @EmbeddedId
//    private TelefonePK chave;

    public Telefone() {
    }

//    public Telefone(TelefonePK chave) {
//        this.chave = chave;
//    }
    public String numeroFormatado() {
        return String.format("(%s) %s", ddd, numero);
//        return String.format("(%s) %s", chave.getDdd(), chave.getNumero());
    }

    public String getCodigoDoPais() {
        return codigoDoPais;
    }

    public void setCodigoDoPais(String codigoDoPais) {
        this.codigoDoPais = codigoDoPais;
    }

//    public TelefonePK getChave() {
//        return chave;
//    }
//
//    public void setChave(TelefonePK chave) {
//        this.chave = chave;
//    }
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

}
