package controller;

import Repository.ClientRepository;
import entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name="InscServlet" , urlPatterns= {"/Inscrire"})
public class InscServlet extends HttpServlet{
	private ClientRepository client ;
	@Override
	public void init() throws ServletException{
		client = new ClientRepository();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String regEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
	    String regTel="^0[5-7][0-9]+$";
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String adresse = request.getParameter("passwd");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int codePostal = Integer.parseInt(request.getParameter("codePost"));
		String ville = request.getParameter("ville");
		String tel = request.getParameter("tel");
		if(email.trim().isEmpty() || passwd.trim().isEmpty() || adresse.trim().isEmpty() || nom.trim().isEmpty()) {
				String msg = "l'un des champs obligatoire est vide !!";
				request.setAttribute("message", msg);
				request.getRequestDispatcher("sinscrire.jsp").forward(request, response);
		}else if(!email.matches(regEmail) || !tel.matches(regTel)) {
			String msg = "erreur dans le syntaxe";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("sinscrire.jsp").forward(request, response);
		}
		else{
			clients clientAdd = new clients();
			clientAdd.setEmail(email);
			clientAdd.setNom(nom);
			clientAdd.setPrenom(prenom);
			clientAdd.setAdresse(adresse);
			clientAdd.setCodePostal(codePostal);
			clientAdd.setVille(ville);
			clientAdd.setTel(tel);
			clientAdd.setMotPasse(passwd);
			boolean resultat = client.inscrire(clientAdd);
			if(resultat == true) {
				String msg = "<p style='color:green'>les informations sont bien energistrer !!</p>";
				request.setAttribute("message", msg);
				request.getRequestDispatcher("sinscrire.jsp").forward(request, response);
			}else {
				String msg = "les informations sont invalide !!";
				request.setAttribute("message", msg);
				request.getRequestDispatcher("sinscrire.jsp").forward(request, response);
			}
		}
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
