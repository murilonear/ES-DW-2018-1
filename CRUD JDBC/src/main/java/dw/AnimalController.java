package dw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/animal-mvc/animal")
public class AnimalController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String op = request.getParameter("op");
    op = (op == null ? "" : op);

    AnimalModel animal = new AnimalModel();
    animal.setNome(request.getParameter("nome"));
    String idadeAnimal = request.getParameter("idade");
    idadeAnimal = (idadeAnimal == null ? "0" : idadeAnimal);
    animal.setIdade(Integer.parseInt(idadeAnimal));
    animal.setRaca(request.getParameter("raca"));

    List<AnimalModel> animais = null;
    try {
      if (op.equals("incluir")) {
        animal.incluir();
      } else if (op.equals("salvar")) {
        animal.salvar();
      } else if (op.equals("excluir")) {
        animal.excluir();
      }

      animais = AnimalModel.listar();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    //Adiciona a variável na requisição para o JSP trabalhar.
    request.setAttribute("animais", animais);

    //Redireciona requisição para o JSP.
    request.
      getRequestDispatcher("/animal-mvc/animal-view.jsp").
      forward(request, response);
  }
}
