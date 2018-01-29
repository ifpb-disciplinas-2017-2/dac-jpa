package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/01/2018, 07:29:58
 */
@Entity
@SequenceGenerator(name = "seq", allocationSize = 1, initialValue = 1, sequenceName = "minha_seq")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//    @SequenceGenerator(name = "seq", allocationSize = 1, initialValue = 1, sequenceName = "minha_seq")
    private int codigo;
    private String nome;
    @Column(length = 14)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String nomeDaMae;
//    @Transient
    private double CRE;
//    private transient double CRE;

    public Aluno() {
    }

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    @SequenceGenerator(name = "seq", allocationSize = 1, initialValue = 1, sequenceName = "minha_seq")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getCRE() {
        return CRE;
    }

    public void setCRE(double CRE) {
        this.CRE = CRE;
    }

}
