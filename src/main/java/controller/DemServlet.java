package controller;

import Repository.ArticleRepository;
import Repository.ClientRepository;
import entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name="DemServlet" , urlPatterns= {"/demandeArticle"})
public class DemServlet extends HttpServlet{
	private ArticleRepository article ;
	@Override
	public void init() throws ServletException{
		article = new ArticleRepository();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String qte = request.getParameter("qte");
		String email = request.getParameter("email");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int idArticle = Integer.parseInt(request.getParameter("idArt"));
		ClientRepository cl = new ClientRepository();
		clients clientInf = cl.GetByEmail(email) ;
		String regQte = "^[0-9]+";
		articles articleDt = article.showArticleById(idArticle);
		if(stock<Integer.parseInt(qte)) {
			 articleDt.setMessage("le nombre d'articles insuffisant.");
		}else if(qte.trim().isEmpty() || !qte.matches(regQte)) {
			articleDt.setMessage("les infromation invalide");
		}else {
			ClientRepository client = new ClientRepository();
			if(client.DemanderArticle(clientInf.getId(), idArticle,Integer.parseInt(qte))) articleDt.setMessage("<p style='color:green'>la demande est bien energistrer.</p>");
			else  articleDt.setMessage("erreur de connexion");
		}
		request.setAttribute("articleDet", articleDt);
		request.getRequestDispatcher("Detaills.jsp").forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
