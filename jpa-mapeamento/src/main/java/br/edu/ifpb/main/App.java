package br.edu.ifpb.main;

import br.edu.ifpb.domain.Departamento;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.Funcionario;
import br.edu.ifpb.domain.Projeto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/02/2018, 07:48:58
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.edu.ifpb_jpa-relacionamento_jar_0.1-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        Endereco endereco = new Endereco("Rua do Nhonho", "Bairro do Chaves", "Cajazeiras");
        Funcionario funcionario = new Funcionario("Nhonho", "1133", endereco);
        Dependente chaves = new Dependente("Chaves");
        Dependente kiko = new Dependente("Kiko");

        Departamento uninfo = new Departamento("UNINFO");

        Projeto bola = new Projeto("Bola quadrada");
        Projeto barriga = new Projeto("Derrubá-lo!");

        funcionario.novoDependente(chaves);
        funcionario.novoDependente(kiko);

        funcionario.novoProjeto(bola);
        funcionario.novoProjeto(barriga);

        funcionario.setDepartamento(uninfo);

        transaction.begin();
        em.persist(uninfo);
        em.persist(kiko);
        em.persist(chaves);
        em.persist(funcionario);
        em.persist(endereco);
        em.persist(bola);
        em.persist(barriga);
        transaction.commit();
        
//        Funcionario funcionario = em.find(Funcionario.class, 5L);
//        funcionario.setEndereco(endereco);
//        transaction.begin(); 
//        em.persist(endereco);
//        em.merge(funcionario); 
//        transaction.commit();

    }

}
