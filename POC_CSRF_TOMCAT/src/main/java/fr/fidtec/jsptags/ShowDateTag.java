package fr.fidtec.jsptags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;

public class ShowDateTag implements Tag {

	private PageContext pageContext = null;
    private Tag parentTag = null;
    
    private boolean displayDate;

	public boolean isDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(boolean displayDate) {
		this.displayDate = displayDate;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter out = pageContext.getOut();
			
			out.println("--- Début du ShowDateTag ---"); 
			
			if (isDisplayDate()) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy EEEE");
				out.print(sdf.format(new Date()));
			} else {
				out.print("ShowDateTag n'est pas configuré pour afficher la date");
			}
			
			out.println("--- Fin du ShowDateTag ---"); 
			
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		
		return SKIP_BODY;
	}
	
	@Override
	public Tag getParent() {
		return parentTag;
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
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;		
	}
}
