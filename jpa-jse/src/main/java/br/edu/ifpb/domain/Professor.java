package br.edu.ifpb.domain;

import br.edu.ifpb.infra.LocalDateConvert;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/01/2018, 09:37:36
 */
@Entity
@TableGenerator(name = "tab", allocationSize = 1, table = "minha_tabela",
        pkColumnValue = "profs")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    private int id;

    private String nome;
    private String matricula;

    @ElementCollection
    @CollectionTable(name = "telefones", foreignKey = @ForeignKey(ConstraintMode.PROVIDER_DEFAULT))
    @Basic(fetch = FetchType.EAGER)
    private List<String> telefones = new ArrayList<>();

    @Convert(converter = LocalDateConvert.class)
    private LocalDate dataDeNascimento = LocalDate.now();

    public Professor() {
    }

    public Professor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void novoTelefone(String tel) {
        this.telefones.add(tel);
    }

    public void removerTelefone(String tel) {
        this.telefones.remove(tel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

}
