package controller;

import Repository.ArticleRepository;
import entities.articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name="ShowDetails" , urlPatterns= {"/Details"})
public class ShowDetails extends HttpServlet{
	private ArticleRepository article ;
	@Override
	public void init() throws ServletException{
		article = new ArticleRepository();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int idArt = Integer.parseInt(request.getParameter("toDeta")); 
		articles articleDt = article.showArticleById(idArt);
		request.setAttribute("articleDet", articleDt);
		request.getRequestDispatcher("Detaills.jsp").forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
