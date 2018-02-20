package br.edu.ifpb.domain.inheritance.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 08:44:05
 */
@Entity
@DiscriminatorValue("TAE") 
public class Tecnico extends Empregado {

    private int numeroDeHoras;
    private String setor;

    public Tecnico() {
    }

    public Tecnico(int numeroDeHoras, String setor, String nome, String cpf) {
        super(nome, cpf);
        this.numeroDeHoras = numeroDeHoras;
        this.setor = setor;
    }

    public int getNumeroDeHoras() {
        return numeroDeHoras;
    }

    public void setNumeroDeHoras(int numeroDeHoras) {
        this.numeroDeHoras = numeroDeHoras;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}
