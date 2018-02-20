package br.edu.ifpb.domain.inheritance.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 07:45:37
 */
@Entity
//@DiscriminatorValue("2")
//@DiscriminatorValue("M")
@DiscriminatorValue("mao")
public class CarroDeMao extends Carro {

    private int numeroDeRodas;

    public CarroDeMao(int numeroDeRodas, String modelo, String ano, String marca) {
        super(modelo, ano, marca);
        this.numeroDeRodas = numeroDeRodas;
    }

    public CarroDeMao() {
    }

    public int getNumeroDeRodas() {
        return numeroDeRodas;
    }

    public void setNumeroDeRodas(int numeroDeRodas) {
        this.numeroDeRodas = numeroDeRodas;
    }

}
