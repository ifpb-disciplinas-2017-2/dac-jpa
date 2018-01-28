package br.edu.ifpb.web;

import br.edu.ifpb.domain.Aluno;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/01/2018, 07:45:40
 */
@Stateless
public class Alunos {

    @PersistenceContext(unitName = "ExemploPUWeb")
    private EntityManager em;
    
    public void salvar(){
        Aluno a = new Aluno("kiko", "123");
        a.setCodigo((int) System.currentTimeMillis());
        em.persist(a);
    }
    
    public List<Aluno> todosOsAlunos() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class)
                .getResultList();
    }
 

}
