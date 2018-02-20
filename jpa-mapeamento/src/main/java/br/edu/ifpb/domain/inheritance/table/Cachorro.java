package br.edu.ifpb.domain.inheritance.table;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 08:16:51
 */
@Entity
public class Cachorro extends Animal {
    private String dono;

    public Cachorro() {
    }

    public Cachorro(String dono, String raca, boolean bonito) {
        super(raca, bonito);
        this.dono = dono;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }
    
}

