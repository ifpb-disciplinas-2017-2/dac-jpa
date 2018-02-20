package br.edu.ifpb.domain.inheritance.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 07:45:43
 */
@Entity
//@DiscriminatorValue("3")
//@DiscriminatorValue("F")
@DiscriminatorValue("Fusca86")
public class Fusca extends Carro {

    private int nivelDeBeleza;

    public Fusca() {
    }

    public Fusca(int nivelDeBeleza, String modelo, String ano, String marca) {
        super(modelo, ano, marca);
        this.nivelDeBeleza = nivelDeBeleza;
    }

    public int getNivelDeBeleza() {
        return nivelDeBeleza;
    }

    public void setNivelDeBeleza(int nivelDeBeleza) {
        this.nivelDeBeleza = nivelDeBeleza;
    }

}
