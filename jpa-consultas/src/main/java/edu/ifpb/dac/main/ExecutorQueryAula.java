package edu.ifpb.dac.main;

import edu.ifpb.dac.model.Dependente;
import edu.ifpb.dac.model.Empregado;
import edu.ifpb.dac.model.EmpregadoIDFaculdade;
import edu.ifpb.dac.model.Faculdade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ExecutorQueryAula {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("consulta");
        EntityManager em = emf.createEntityManager();

//        connsultaSimples(em);
//        consultarTodosOsEmpregados(em);
//        consultarFaculdadeComId(em);
//        consultarFaculdadeComIdParametros(em);
//        consultarDependentesComPaginacao(em);
//        consultarNomeDosEmpregados(em);
//        consultarNomeDoEmpregadoEFaculdade(em);
//        consultarNomeDoEmpregadoEFaculdadeComTipo(em);
//        consultarNomeDoEmpregadoQuePossuiDependentes(em);
//        consultarNomeDoEmpregadoPossuiDependentesJOIN(em);
//        consultarNomeDoEmpregadoPossuiDependentesLEFTJOIN(em);
//        consultarDependentesComIdEntre(em);
//        consultarDependentesComIdEntreBETWEEN(em);
//        consultarDependentesComIdForaBETWEEN(em);
//        consultarEmpregadoSemFaculdade(em);
//        consultarEmpregadoComFaculdade(em);
//        consultarEmpregadoPossuiDependente(em);
//        consultarEmpregadoDependenteComNome(em);
//        consultarPrimeiraLetraDependente(em);
//        consultarNumeroDeTodosOsDependentes(em);
//        consultarNomeDoEmpregadoEQuantidadeDependentes(em);
//        consultarEmpregadoComIdSuperiorAMedia(em);
        consultarEmpregadoSeTodosIdSuperiorADez(em);
//        consultarEmpregadoSeQualquerIdSuperiorADez(em);
//        consultarEmpregadoComDependentesInicandoComM(em);
//        atualizarNomeTodosDependentes(em);
//        removerDependenteComId(em);
//        consultarTodosOsDependentesNamedQuery(em);
//        consultarOsDependentesComIdNamedQuery(em);
//        consultarTodosOsEmpregadosNativeQuery(em);
    }

    private static void connsultaSimples(EntityManager em) {
        Query createQuery = em.createQuery("SELECT e FROM Empregado e");
        // principais métodos da Query
//        Object singleResult = createQuery.getSingleResult();
        List resultList = createQuery.getResultList();
        for (Object object : resultList) {
            Empregado e = (Empregado) object;
        }

        TypedQuery<Empregado> query = em.createQuery("SELECT e FROM Empregado e", Empregado.class);
        List<Empregado> list = query.getResultList();
        for (Empregado empregado : list) {

        }
    }

    private static void consultarTodosOsEmpregados(EntityManager em) {
        System.out.println("---LISTAR O NOME DOS EMPREGADOS---");
        String jpql = "SELECT e FROM Empregado e";
        TypedQuery<Empregado> createQuery = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = createQuery.getResultList();
        for (Empregado empregado : resultList) {
            System.out.println(empregado.getNome());
        }
    }

    private static void consultarEmpregadoComId(EntityManager em) {
        //select * from empregado as e where e.id =1
        System.out.println("---LISTAR O EMPREGADO POR ID---");
        String jpql = "SELECT e FROM Empregado e WHERE e.id=1";
        TypedQuery<Empregado> createQuery = em.createQuery(jpql, Empregado.class);
        Empregado empregado = createQuery.getSingleResult();
        System.out.println(empregado.getNome());
    }

    private static void consultarFaculdadeComIdParametros(EntityManager em) {
        String descricao = "IFPB";
//        String descricao = "I' OR '1'='1";
        //select * from faculdade 
        System.out.println("---LISTAR A FACULDADE COM ID---");
//        String jpql = String.format("SELECT f FROM Faculdade f WHERE f.descricao='%s'", id);
//        String jpql = "SELECT f FROM Faculdade f WHERE f.descricao=?1";
        String jpql = "SELECT f FROM Faculdade f WHERE f.descricao=:descricao";
        TypedQuery<Faculdade> createQuery = em.createQuery(jpql, Faculdade.class);
//        createQuery.setParameter(1, descricao);
        createQuery.setParameter("descricao", descricao);
        List<Faculdade> resultList = createQuery.getResultList();
        for (Faculdade faculdade : resultList) {
            System.out.println(faculdade.getDescricao());
        }
    }

    private static void consultarDependentesComPaginacao(EntityManager em) {
        // Quantos dependentes temos?
        String total = "SELECT COUNT(d) FROM Dependente d";
        long totalDeDependentes = em.createQuery(total, Long.class).getSingleResult();
        int itensPorPagina = 2;
        int inicio = 0;
//        int count = 1;
        String jpql = "SELECT d FROM Dependente d";
        TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
        do {
            int pagina = (inicio / itensPorPagina) + 1;
//            System.out.println("Pag. " + count);
            System.out.println("Pag. " + pagina);
            query.setFirstResult(inicio).setMaxResults(itensPorPagina);
            List<Dependente> lista = query.getResultList();
            lista.forEach(d -> System.out.println(d.getNome()));
//            count++;
            inicio = inicio + itensPorPagina;
        } while (totalDeDependentes > inicio);

    }

    private static void consultarNomeDosEmpregados(EntityManager em) {
        // SELECT e.nome FROM Empregado e
        String jpql = "SELECT e.nome FROM Empregado e";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList().forEach(System.out::println);

    }

    private static void consultarNomeDoEmpregadoEFaculdade(EntityManager em) {
        String jpql = "SELECT e.nome, e.faculdade, e.id FROM Empregado e";
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        for (Object[] coluna : lista) {
            System.out.print(coluna[0]);
            System.out.print(" - " + coluna[1]);
            System.out.println(" - " + coluna[2]);
        }
    }

    private static void consultarNomeDoEmpregadoEFaculdadeComTipo(EntityManager em) {
        String jpql = "SELECT new edu.ifpb.dac.model.EmpregadoIDFaculdade(e.nome, e.faculdade, e.id) FROM Empregado e";
        TypedQuery<EmpregadoIDFaculdade> query = em.createQuery(jpql, EmpregadoIDFaculdade.class);
        List<EmpregadoIDFaculdade> lista = query.getResultList();
        for (EmpregadoIDFaculdade empregadoIDFaculdade : lista) {
            System.out.print(empregadoIDFaculdade.getNome());
            System.out.print(" - " + empregadoIDFaculdade.getId());
            System.out.println(" - " + empregadoIDFaculdade.getFaculdade());
        }
    }

    private static void consultarNomeDoEmpregadoQuePossuiDependentes(EntityManager em) {
        String jpql = "SELECT e.nome, d.nome FROM Empregado e, IN(e.dependentes) d";
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        for (Object[] coluna : lista) {
            System.out.print(coluna[0]);
            System.out.println(" - " + coluna[1]);
        }
    }

    private static void consultarNomeDoEmpregadoPossuiDependentesJOIN(EntityManager em) {
        String jpql = "SELECT e.nome, d.nome FROM Empregado e JOIN e.dependentes d";
//        String jpql = "SELECT e.nome, d.nome FROM Empregado e JOIN Dependente d";
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        for (Object[] coluna : lista) {
            System.out.print(coluna[0]);
            System.out.println(" - " + coluna[1]);
        }
    }

    private static void consultarNomeDoEmpregadoPossuiDependentesLEFTJOIN(EntityManager em) {
        String jpql = "SELECT e.nome, COUNT(d) FROM Empregado e LEFT JOIN e.dependentes d GROUP BY e.nome";
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        for (Object[] coluna : lista) {
            System.out.print(coluna[0]);
            System.out.println(" - " + coluna[1]);
        }
    }

    private static void consultarDependentesComIdEntre(EntityManager em) {
        // SELECT * FROM Dependente d WHERE d.id>=0 AND d.id<=20
        int inicio = 4;
        int fim = 20;
        String jpql = "SELECT d FROM Dependente d WHERE (d.id-1) >=:inicio AND d.id<=:fim";
        TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        List<Dependente> lista = query.getResultList();
        lista.forEach(dep -> System.out.println(dep.getId() + " - " + dep.getNome()));

    }

    private static void consultarDependentesComIdEntreBETWEEN(EntityManager em) {
        int inicio = 5;
        int fim = 20;
        String jpql = "SELECT d FROM Dependente d WHERE d.id BETWEEN :inicio AND :fim";
        TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        List<Dependente> lista = query.getResultList();
        lista.forEach(dep -> System.out.println(dep.getId() + " - " + dep.getNome()));
    }

    private static void consultarDependentesComIdForaBETWEEN(EntityManager em) {
        int inicio = 6;
        int fim = 20;
        String jpql = "SELECT d FROM Dependente d WHERE d.id NOT BETWEEN :inicio AND :fim";
        TypedQuery<Dependente> query = em.createQuery(jpql, Dependente.class);
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        List<Dependente> lista = query.getResultList();
        lista.forEach(dep -> System.out.println(dep.getId() + " - " + dep.getNome()));
    }

    private static void consultarEmpregadoSemFaculdade(EntityManager em) {
        String jpql = "SELECT e FROM Empregado e WHERE e.faculdade IS NULL";
        TypedQuery<Empregado> query = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = query.getResultList();
        for (Empregado empregado : resultList) {
            System.out.println(empregado.getNome());
//            System.out.println(empregado.getFaculdade().getDescricao());
        }
    }

    private static void consultarEmpregadoComFaculdade(EntityManager em) {
//        String jpql = "SELECT e FROM Empregado e WHERE e.faculdade NOT IS NULL";
        String jpql = "SELECT e FROM Empregado e WHERE e.faculdade IS NOT NULL";
        TypedQuery<Empregado> query = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = query.getResultList();
        for (Empregado empregado : resultList) {
            System.out.println(empregado.getNome());
            System.out.println(empregado.getFaculdade().getDescricao());
        }
    }

    private static void consultarEmpregadoPossuiDependente(EntityManager em) {
        String jpql = "SELECT e FROM Empregado e WHERE e.dependentes IS NOT EMPTY";
        TypedQuery<Empregado> query = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = query.getResultList();
        for (Empregado empregado : resultList) {
            System.out.println(empregado.getNome() + " " + empregado.getDependentes().size());

        }
    }

    private static void consultarEmpregadoDependenteComNome(EntityManager em) {
        //Selecionar os empregados que possuem dependentes que começam com a letra M
        String jpql = "SELECT UPPER(e.nome) FROM Empregado e, Dependente d WHERE d MEMBER OF e.dependentes "
                + " AND LOWER(d.nome) LIKE 'm%' ";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList().forEach(System.out::println);
    }

    private static void consultarPrimeiraLetraDependente(EntityManager em) {
        //Selecionar apenas a primeira letra do nome dos dependentes
        String jpql = "SELECT SUBSTRING(d.nome, 1, 1) FROM Dependente d ORDER BY d.nome";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList().forEach(System.out::println);
//        query.getResultList().forEach(nome->{System.out.println(nome.substring(0, 1));});
    }

    private static void consultarNumeroDeTodosOsDependentes(EntityManager em) {
        String jqpl = "SELECT COUNT(d) FROM Dependente d";
        TypedQuery<Long> createQuery = em.createQuery(jqpl, Long.class);
        Long total = createQuery.getSingleResult();
        System.out.println("total = " + total);
    }

    private static void consultarNomeDoEmpregadoEQuantidadeDependentes(EntityManager em) {
        String jpql = "SELECT e.nome, COUNT(d) FROM Empregado e LEFT JOIN e.dependentes d GROUP BY e.nome";
        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        for (Object[] coluna : lista) {
            System.out.print(coluna[0]);
            System.out.println(" - " + coluna[1]);
        }
    }

    private static void consultarEmpregadoComIdSuperiorAMedia(EntityManager em) {
        String jpql = " SELECT e FROM Empregado e WHERE e.id> (SELECT AVG(emp.id) FROM Empregado emp)";
        TypedQuery<Empregado> createQuery = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = createQuery.getResultList();
        resultList.forEach(e -> System.out.println(e.getNome()));

    }

    private static void consultarEmpregadoSeTodosIdSuperiorADez(EntityManager em) {
//        String jpql = " SELECT e FROM Empregado e WHERE (SELECT COUNT(emp.id) FROM Empregado emp) = "
//                + "(SELECT COUNT(x) FROM Empregado x WHERE x.id>0)";
        String jpql = " SELECT e FROM Empregado e WHERE 10 < ALL (SELECT emp.id FROM Empregado emp)";
        TypedQuery<Empregado> createQuery = em.createQuery(jpql, Empregado.class);
        List<Empregado> resultList = createQuery.getResultList();
        resultList.forEach(e -> System.out.println(e.getNome()));
    }
}
