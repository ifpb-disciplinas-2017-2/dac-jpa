package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/01/2018, 09:37:36
 */
@Entity
@Table(name = "tecnico_adm")
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 80)
    private String nome;
    @Column(name = "mat_siape", length = 25, nullable = true)
    private String siape;
    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "cpf", length = 11))
    // 123.123.123-09
    private CPF cpf = new CPF("12312312331");

    @Embedded
    private Endereco endereco;

    public Tecnico() {
    }

    public Tecnico(String nome, String matricula) {
        this.nome = nome;
        this.siape = matricula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
