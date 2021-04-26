package entities;

import java.util.ArrayList;
import java.util.List;

public class ArticleMod {
	private String genre;
	private List<articles> articles = new ArrayList<articles>();
	private List<String> categories = new ArrayList<String>();
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<articles> getArticles() {
		return articles;
	}
	public void setArticles(List<articles> articles) {
		this.articles = articles;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getCategories(){
		return categories;
	}
	
}
