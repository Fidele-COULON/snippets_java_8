package fr.fidtec.jsptags;

import java.io.IOException;
import java.io.StringWriter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	
	private String message;
    public void setMessage(String msg) {
      this.message = msg;
    }
	   
	@Override
	public void doTag() throws JspException, IOException {
	  
      JspWriter out = getJspContext().getOut();
		  
      out.println("--- Debut du HelloTag ---"); 
      
	  if (message != null) { // Use message from attribute
		  out.println(message);
	  } else { // use message from the body
		  StringWriter sw = new StringWriter();
		  getJspBody().invoke(sw);
		  out.println(sw.toString());
	  }
	      	      
	  out.println("--- Fin du HelloTag ---"); 
	}

}
