package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Professor;
import br.edu.ifpb.domain.Sexo;
import br.edu.ifpb.domain.Tecnico;
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
        Professor prof = new Professor("Job", "312331");
        Tecnico tec = new Tecnico("Madruga", "7657");
        Aluno a = new Aluno("kiko", "123");
        a.setSexo(Sexo.MASCULIN);
//        a.setCodigo((int) System.currentTimeMillis());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
//        List<Aluno> resultList = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
//        resultList.forEach(aluno -> System.out.println(aluno.getNome()));
//
//        Aluno aluno = em.find(Aluno.class, 1);
//        System.out.println(aluno.getSexo());
//        a.setNome("Madruga");

//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.merge(a);
//        transaction.commit();
    }
}
