package br.edu.ifpb.domain.inheritance.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 08:43:41
 */
@Entity
@DiscriminatorValue("Prof")
public class Professor extends Empregado {

    private String matricula;
    private int numeroDeAulas;

    public Professor() {
    }

    public Professor(String matricula, int numeroDeAulas, String nome, String cpf) {
        super(nome, cpf);
        this.matricula = matricula;
        this.numeroDeAulas = numeroDeAulas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumeroDeAulas() {
        return numeroDeAulas;
    }

    public void setNumeroDeAulas(int numeroDeAulas) {
        this.numeroDeAulas = numeroDeAulas;
    }

}
