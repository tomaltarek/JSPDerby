package tomal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tomal.entity.Users;
import tomal.util.DBConnectionUtil;

public class UsersDAOImpl implements UsersDAO {

	Connection connection=null; 
	Statement statement=null; 
	ResultSet resultSet=null; 
	PreparedStatement preparedStatement=null; 
	@Override
	public List<Users> get() {
		//create a reference variable 
		List<Users> list =null; 
		Users users=null; 
		
		try {
			list= new ArrayList<Users>();
			//create a sql query
			
			String sql="select * from users";
			
			// get database connection 
			connection=DBConnectionUtil.openConnection();
			
			// create a statement 
			statement=connection.createStatement();
			
			// execute the query 
			resultSet=statement.executeQuery(sql);
			//System.out.println("test");
			
		
			while (resultSet.next()) {
				//System.out.println(resultSet.getString("password"));
				users=new Users();
				users.setName(resultSet.getString("username")); 
				users.setPass(resultSet.getString("password")); 
				list.add(users);
			} 
			
			// add users to list 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return the list 
		return list; 
					
	}
	@Override
	public boolean save(Users e) {
		boolean flag=false;
		try {
			String sql = "INSERT INTO USERS(username, password)VALUES"
					+ "('"+e.getName()+"', '"+e.getPass()+"')";
			connection=DBConnectionUtil.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return flag;
	}
	@Override
	public Users get(String u) {
		Users user = null;
		try {
			user = new Users();
			String sql = "SELECT * FROM users where username="+"'"+u+"'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				user.setName(resultSet.getString("username"));			
				user.setPass(resultSet.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	@Override
	public boolean update(Users u,String s) {
		boolean flag = false;
		try {
			String sql = "UPDATE users SET username = '"+u.getName()+"', "
					+ "password = '"+u.getPass()+"' where username='" +s+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean delete(String s) {
		boolean flag = false;
		try {
			String sql = "delete from users where username='" +s+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
	
