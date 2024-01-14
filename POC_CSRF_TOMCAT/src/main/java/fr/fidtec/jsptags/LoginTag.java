package fr.fidtec.jsptags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class LoginTag extends SimpleTagSupport {
	
	private String action = "";
    private String login = "";
    private String password = "";
    
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Override
    public void doTag() throws JspException, IOException {
        
    	JspWriter out = getJspContext().getOut();
        
        out.print("<form method='POST' ");
        
        if (action != null) {
        	out.print("action='" + action + "' ");
        }
        
        out.println("style='border: 1px solid black; width: 60%; margin: auto;'>");
        
        out.println("Login : ");
        out.println("<input name='name' value=\"" + login.replace( "\"", "&quot;" ) + "\" autofocus />");
        out.println("<br/>");

        out.println("Password : ");
        out.println("<input name='password' type='password' value=\"" + password.replace( "\"", "&quot;" ) + "\" />");
        out.println("<br/><br/>");
        
        out.println("<input type='submit' value='Connect' />");
        out.println("<br/><br/>" );
        
        out.print("</form>");
            
    }

}
