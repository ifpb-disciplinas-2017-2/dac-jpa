/**
 * This file was generated by the Jeddict
 */
package br.edu.ifpb.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 */
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String nome;

    @Basic
    private String cpf;

    // 1-1
    @OneToOne
    private Endereco endereco;

    // 1-N
    @OneToMany()
    @JoinColumn(name = "id_funcionario")
    private Set<Dependente> dependentes = new HashSet<>();

    // N-1
    @ManyToOne
    private Departamento departamento;

    // N-N
    @ManyToMany
    @JoinTable(name = "Trabalho")
    private List<Projeto> projetos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void novoDependente(Dependente dependente) {
        this.dependentes.add(dependente);
    }

    public void excluirDependente(Dependente dependente) {
        this.dependentes.remove(dependente);
    }

    public void novoProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public void excluirProjeto(Projeto projeto) {
        this.projetos.remove(projeto);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Funcionario cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcionario endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Set<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(Set<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
