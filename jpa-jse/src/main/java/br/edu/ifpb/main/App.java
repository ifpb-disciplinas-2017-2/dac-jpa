package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/01/2018, 08:19:53
 */
public class App {

    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("ExemploPU")
                .createEntityManager();

//        Aluno a = new Aluno("kiko", "123");
//        a.setCodigo((int) System.currentTimeMillis());
//           EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.persist(a);
//        transaction.commit();
        List<Aluno> resultList = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        resultList.forEach(aluno -> System.out.println(aluno.getNome()));

        Aluno a = em.find(Aluno.class, 1);
        a.setNome("Madruga");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(a);
        transaction.commit();

    }
}
