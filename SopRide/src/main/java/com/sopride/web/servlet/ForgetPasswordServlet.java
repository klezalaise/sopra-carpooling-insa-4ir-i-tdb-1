package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.UserBE;
import com.sopride.core.exception.NoUserEmailException;
import com.sopride.dao.UserDAO;
import com.sopride.web.util.RandomUtil;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	WebUtils.forward(request, response, "forgetPassword.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoUserEmailException  {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		UserDAO DAO = UserDAO.getInstance();
		UserBE User = DAO.findByEmail(email);
		if(User == null){
			throw new NoUserEmailException("forgetPassword.jsp", "Il n'existe aucun utilisateur avec cet email");
		}
		else{
		String newpassword = RandomUtil.randomString(10);
		User.setPassword(newpassword); 
		WebUtils.sendMailHTML(email, "Mot de passe oubli�", "<h1> R�cup�ration du mot de passe : </h1> <h3>Voici votre mail : " + email + "</h3> <h3>Votre nouveau mot de passe : " + newpassword
				+"</h3>");
		WebUtils.forward(request, response,"mailSent.jsp" );
		}
	}

}
