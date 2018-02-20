package br.edu.ifpb.domain.inheritance.table;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 08:17:04
 */
@Entity
public class Gato extends Animal {

    private int nivelDePreguica;

    public Gato() {
    }

    public Gato(int nivelDePreguica, String raca, boolean bonito) {
        super(raca, bonito);
        this.nivelDePreguica = nivelDePreguica;
    }

    public int getNivelDePreguica() {
        return nivelDePreguica;
    }

    public void setNivelDePreguica(int nivelDePreguica) {
        this.nivelDePreguica = nivelDePreguica;
    }

}
