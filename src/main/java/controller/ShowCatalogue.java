package controller;

import Repository.ArticleRepository;
import entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="ShowCatalogue" , urlPatterns= {"/catalogue"})
public class ShowCatalogue extends HttpServlet{
	private ArticleRepository article ;
	@Override
	public void init() throws ServletException{
		article = new ArticleRepository();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String motCle = request.getParameter("option");
		ArticleMod mod = new ArticleMod();
		List<String> categs = article.showAllCat();
		if(motCle == null) motCle = categs.get(0);
		mod.setGenre(motCle);
		List<articles> articles = article.showArticle(motCle);
		mod.setArticles(articles);
		List<String> categories = article.showAllCat();
		mod.setCategories(categories);
		request.setAttribute("modele", mod);
		request.getRequestDispatcher("ShowCatalogue.jsp").forward(request,response);
		
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
