package edu.ifpb.dac.model;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/02/2018, 11:09:21
 */
public class EmpregadoIDFaculdade implements Serializable {

    private int id;
    private String nome;
    private Faculdade faculdade;

    public EmpregadoIDFaculdade() {
    }

    public EmpregadoIDFaculdade(String nome, Faculdade faculdade, int id) {
        this.id = id;
        this.nome = nome;
        this.faculdade = faculdade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    @Override
    public String toString() {
        return "EmpregadoIDFaculdade{" + "id=" + id + ", nome=" + nome + ", faculdade=" + faculdade + '}';
    }
    

}
