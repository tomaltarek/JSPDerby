package tomal.entity;

public class Users {
	// Define fields
	private String name; 
	private String pass;
	
	// Define setters and getters (by Alt+Shft+s)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	// Generate toString() (by usign alt+shft+s) 
	@Override
	public String toString() {
		return "Users [name=" + name + ", pass=" + pass + "]";
	} 
	
		
	
	
	

}
