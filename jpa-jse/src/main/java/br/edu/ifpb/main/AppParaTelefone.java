package br.edu.ifpb.main;

import br.edu.ifpb.domain.Telefone;
import br.edu.ifpb.domain.TelefoneChave;
import br.edu.ifpb.domain.TelefonePK;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 05/02/2018, 08:57:43
 */
public class AppParaTelefone {

    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("ExemploPU")
                .createEntityManager();

//        TelefonePK pk = new TelefonePK("87", "988109101");
//        Telefone telefone = new Telefone(pk);
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.persist(telefone);
//        transaction.commit();
        TelefoneChave pk = new TelefoneChave("87", "988109101");
        Telefone find = em.find(Telefone.class, pk);
        System.out.println(find.numeroFormatado());

    }
}
