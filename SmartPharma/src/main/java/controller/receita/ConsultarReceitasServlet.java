package controller.receita;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.repository.ReceitaRepository;
import model.Receita;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Servlet implementation class ConsultarReceitasServlet
 */
@WebServlet({"/receita", "/receita/consultar"})
public class ConsultarReceitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarReceitasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ReceitaRepository repositorio = new ReceitaRepository();
		
		Collection<Receita> receitas = ReceitaRepository.recuperarReceitas();
		
		if(receitas == null)
		{
			receitas = new ArrayList<Receita>();
		}
		
		request.setAttribute("receitas", receitas);
		request.setAttribute("tituloPagina", "Receitas Cadastradas");
		request.setAttribute("pathPagina", "/views/receita/consultar.jsp");
		request.setAttribute("pathView", "/views/receita/consultar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
		
		/*
		
		Collection<Receita> receitas = ReceitaRepository.recuperarReceitas();
		
		request.setAttribute("tituloPagina", "Receitas");
		request.setAttribute("receitasCadastradas", receitas);
//		request.setAttribute("doServidor", true);
		request.setAttribute("pathPagina", "/views/receita/consultar.jsp");
		request.setAttribute("pathView", "/views/receita/consultar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
	}

}
