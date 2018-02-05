package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2018, 07:26:48
 */
@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    // CLOB
    private String descricao;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    // BLOB
    private byte[] foto;
    @Temporal(TemporalType.TIMESTAMP)
    // 12/10/2018
    private Date dataDeCriacao;

//    OffsetDateTime time = OffsetDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault());

    public Perfil() {
//        System.out.println(OffsetDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
        this.dataDeCriacao = new Date();
    }

    public Perfil(String nome) {
        this();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
    

}
