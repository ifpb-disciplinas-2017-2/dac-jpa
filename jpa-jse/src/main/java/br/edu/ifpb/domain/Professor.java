package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
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
@TableGenerator(name = "tab", allocationSize = 1,table = "minha_tabela", 
        pkColumnValue = "profs")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "tab")
    private int id;

    private String nome;
    private String matricula;

    public Professor() {
    }

    public Professor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
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

}
