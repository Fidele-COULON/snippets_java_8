package fr.fidtec.jsptags;

import java.io.IOException;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;

public class LoginCSRFTag implements Tag {

	private String action = "";
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	private PageContext pageContext = null;
	private Tag parentTag = null;
	
	@Override
	public int doStartTag() throws JspException {
		
		try {
						
			JspWriter out = pageContext.getOut();
						
			out.print("<form method='POST' action='" + action + "'>");
			out.print("<input type='hidden' name=" + CSRF_Utils.CSRF_TOKEN + " value='" + CSRF_Utils.generateCSRFToken() + "'>"); 
			
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		
		return Tag.EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.print("</form>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	@Override
	public void release() {
		pageContext = null;	
		parentTag = null;		
	}
	
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		
	}
	@Override
	public Tag getParent() {
		return parentTag;
	}
	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;			
	}
}
