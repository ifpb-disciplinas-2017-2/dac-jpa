package br.edu.ifpb.domain.inheritance.table;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 08:15:49
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Animal implements Serializable {
//public abstract class Animal implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String raca;
    private boolean bonito;

    public Animal() {
    }

    public Animal(String raca, boolean bonito) {
        this.raca = raca;
        this.bonito = bonito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isBonito() {
        return bonito;
    }

    public void setBonito(boolean bonito) {
        this.bonito = bonito;
    }

}
