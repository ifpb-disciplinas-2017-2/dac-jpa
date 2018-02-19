package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/02/2018, 09:08:11
 */
@Entity
public class Gerente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @OneToOne
    private Departamento departamento; // 1-1 bidirecional

    @OneToMany(mappedBy = "gerente")
    private Set<Projeto> projetos = new HashSet<>(); // 1-* bidirecional

    public Gerente(String nome) {
        this.nome = nome;
    }

    public Gerente() {
    }

    public void novoProjeto(Projeto projeto) {
//        projeto.setGerente(this);
        this.projetos.add(projeto);
    }

    public void excluirProjeto(Projeto projeto) {
        this.projetos.remove(projeto);
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Set<Projeto> getProjetos() {
        return Collections.unmodifiableSet(projetos);
    }

    public void setProjetos(Set<Projeto> projetos) {
        this.projetos = projetos;
    }

}
