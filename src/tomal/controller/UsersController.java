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
       
	RequestDispatcher dispatcher = null;
	String old_name=null; 
	//create a ref variable for UsersDAO
	UsersDAO usersDAO=null; 
	boolean decision=true;

	
	
	//create constructor and initialize Users DAO 
   public UsersController() {
		usersDAO=new UsersDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
       
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listUsers(request, response);
				break;
				
			case "EDIT":
				getSingleUser(request, response);
				break;
//				
//			case "DELETE":
//				deleteEmployee(request, response);
//				break;
//				
			default:
				listUsers(request, response);
				break;
				
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		Users e= new Users();
		e.setName(name);
		e.setPass(password);
		//usersDAO.save(e);
		
//		 if (usersDAO.save(e)) {
//	 			
// 			request.setAttribute("message", "Saved Successfully");
//	 	}
		
		 
    if(decision==true) {
			
			if(usersDAO.save(e)) {
				request.setAttribute("message", "Saved Successfully");
			}
		
		}else {
			
			
			if(usersDAO.update(e,old_name)) {
				request.setAttribute("message", "Update Successfully");
			}
			
		}
	
 	listUsers(request, response);
		decision=true;
		
	}
	
private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Users> theList = usersDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/users-list.jsp");
		
		dispatcher.forward(request, response);
	}

private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	decision=false;
	String uname = request.getParameter("id");	
	Users theUser = usersDAO.get(uname);
	old_name=theUser.getName();
	request.setAttribute("user", theUser);

	dispatcher = request.getRequestDispatcher("/views/users-form.jsp");
	
	dispatcher.forward(request, response);
}

}
