package modelo;

public class Bean {
	
	private String email;
	private String password;
	
	public String getemail() {
		return email;	
		}
	
	public void setemail(String email) {
		this.email= email;	
		}
	public String getpassword() {
		return password;	
		}
	public void setpassword(String password) {
		this.password= password;	
		}
	
	public boolean comprueba() {
		if(this.password.equals("12345") && this.email.equals("pepe@email.com"))
			return true;
		return false;
	}

}
