package br.edu.ifpb.main;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Perfil;
import br.edu.ifpb.domain.Professor;
import br.edu.ifpb.domain.Sexo;
import br.edu.ifpb.domain.Tecnico;
import br.edu.ifpb.infra.ImageFile;
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
        prof.novoTelefone("234245552");
        prof.novoTelefone("234233552");
        prof.novoTelefone("234242888");
        Tecnico tec = new Tecnico("Madruga", "7657");
        Aluno a = new Aluno("kiko", "123");
        a.setSexo(Sexo.MASCULIN);
//        a.setCodigo((int) System.currentTimeMillis());

        Perfil perfil = new Perfil();
        perfil.setDescricao("Sou eu!");
        byte[] foto = new ImageFile("src/main/resources/chaves.jpeg").toBytes();
        perfil.setFoto(foto);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prof);
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
//        Perfil find = em.find(Perfil.class, 1);
//        find.getNome();
//        
//        find.getDescricao();  // recuperar a informação
//        Professor p = em.find(Professor.class, 1);
//        List<String> tels = p.getTelefones();
//        System.out.println(tels.size());
//        System.out.println(tels.get(0));
//        
//        for (String tel : tels) {
//            System.out.println(tel);
//        }
//        
//        tels.stream().forEach(t -> System.out.println(t));
//        System.out.println(tels.stream().count());
//        System.out.println(tels.size());
    }
}
