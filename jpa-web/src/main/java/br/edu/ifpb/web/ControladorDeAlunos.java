package br.edu.ifpb.web;

import br.edu.ifpb.infra.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDeAlunos", urlPatterns = {"/alunos"})
public class ControladorDeAlunos extends HttpServlet {

    @EJB
    private Alunos alunos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        alunos.salvar();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Listagem de Alunos </h1>");
//            out.println("<h2> ******** </h2>");
            imprimirTodosOsClientes(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void imprimirTodosOsClientes(final PrintWriter out) {
        alunos
                .todosOsAlunos()
                .forEach(
                        c -> out.println("<p>" + c.getNome() + "</p>")
                );
    }

}
