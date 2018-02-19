package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Projeto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/02/2018, 09:10:45
 */
public class AppBidirecional {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.edu.ifpb_jpa-relacionamento_jar_0.1-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

//        salvarDepartamentoGerente(transaction, em);
//        localizandoDepartamentoGerente(em);
//        atualizarNomeGerente(transaction, em);
        salvarProjetoGerente(transaction, em);

    }

    private static void salvarDepartamentoGerente(EntityTransaction transaction, EntityManager em) {
        Departamento departamento = new Departamento("UNINFO");
        Gerente gerente = new Gerente("Job");
        //
        gerente.setDepartamento(departamento);
        departamento.setGerente(gerente);
        transaction.begin();
        em.persist(gerente);
        em.persist(departamento);
        transaction.commit();
    }

    private static void localizandoDepartamentoGerente(EntityManager em) {
        Departamento departamento = em.find(Departamento.class, 2);
        System.out.println("Nome = " + departamento.getGerente().getNome());

        Gerente gerente = em.find(Gerente.class, 1);
        System.out.println("Abreviação = " + gerente.getDepartamento().getAbreviacao());
    }

    private static void atualizarNomeGerente(EntityTransaction transaction, EntityManager em) {
        Departamento departamento = em.find(Departamento.class, 2);
        departamento.getGerente().setNome("Kiko");

        transaction.begin();
        em.merge(departamento);
        transaction.commit();
    }

    private static void salvarProjetoGerente(EntityTransaction transaction, EntityManager em) {
        Gerente gerente = new Gerente("Florinda");
        Projeto etapa1 = new Projeto("Etapa 1");
        Projeto etapa2 = new Projeto("Etapa 2");

        gerente.novoProjeto(etapa1);
        gerente.novoProjeto(etapa2);
        etapa1.setGerente(gerente);
        etapa2.setGerente(gerente);

        transaction.begin();
        em.persist(etapa1);
        em.persist(etapa2);
        em.persist(gerente);
        transaction.commit();

    }
}
