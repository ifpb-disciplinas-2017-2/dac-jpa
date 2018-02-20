package br.edu.ifpb.main;

import br.edu.ifpb.domain.inheritance.joined.Empregado;
import br.edu.ifpb.domain.inheritance.joined.Professor;
import br.edu.ifpb.domain.inheritance.joined.Tecnico;
import br.edu.ifpb.domain.inheritance.single.Carro;
import br.edu.ifpb.domain.inheritance.single.CarroDeMao;
import br.edu.ifpb.domain.inheritance.single.Fusca;
import br.edu.ifpb.domain.inheritance.table.Animal;
import br.edu.ifpb.domain.inheritance.table.Cachorro;
import br.edu.ifpb.domain.inheritance.table.Gato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/02/2018, 07:48:33
 */
public class AppHeranca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.edu.ifpb_jpa-relacionamento_jar_0.1-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

//        salvarCarros(transaction, em);
//        salvarOsAnimais(transaction, em);
//        salvarOsEmpregados(transaction, em);
        pesquisarProfessor(em);
    }

    private static void salvarCarros(EntityTransaction transaction, EntityManager em) {
        Carro carro = new Carro("Focus", "2018", "Ford");
        Fusca fusca = new Fusca(100, "Fusca", "1986", "VW");
        CarroDeMao carrinho = new CarroDeMao(3, "Axé", "1996", "Axé");

        transaction.begin();
        em.persist(carro);
        em.persist(carrinho);
        em.persist(fusca);
        transaction.commit();
    }

    private static void salvarOsAnimais(EntityTransaction transaction, EntityManager em) {
        Animal leao = new Animal("Leão", false);
        Cachorro pug = new Cachorro("Tu", "Pug", false);
        Gato bichano = new Gato(100, "Vira lata", true);

        transaction.begin();
        em.persist(leao);
        em.persist(pug);
        em.persist(bichano);
        transaction.commit();
    }

    private static void salvarOsEmpregados(EntityTransaction transaction, EntityManager em) {
        Empregado empregado = new Empregado("Madruga", "123");
        Professor job = new Professor("122", 17, "Job", "124");
        Tecnico alan = new Tecnico(40, "LCM", "Alan", "125");

        transaction.begin();
        em.persist(empregado);
        em.persist(job);
        em.persist(alan);
        transaction.commit();
    }

    private static void pesquisarProfessor(EntityManager em) {
        Professor professor = em.find(Professor.class, 2);

        System.out.println("Nome: " + professor.getNome());
        System.out.println("Matricula: " + professor.getMatricula());
    }
}
