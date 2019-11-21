package tomal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tomal.dao.UsersDAO;
import tomal.dao.UsersDAOImpl;
import tomal.entity.Users;

/**
 * Servlet implementation class UsersController
 */
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//create a ref variable for UsersDAO
	UsersDAO usersDAO=null; 
	
	//create constructor and initialize Users DAO 
   public UsersController() {
		usersDAO=new UsersDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// call DAO method to get list of users 
		List<Users> list=usersDAO.get();
		
		// add the users to request 
		request.setAttribute("list", list);
		
		// get the request dispatcher 
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/users-list.jsp");
		
		//forward req and res object 
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		Users e= new Users();
		e.setName(name);
		e.setPass(password);
		usersDAO.save(e);
		/*if (usersDAO.save(e)) {
			
			request.setAttribute("message", "Saved Successfully");
		}*/
		
		
	}

}
