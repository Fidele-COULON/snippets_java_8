package fr.fidtec.jsptags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.BodyContent;
import jakarta.servlet.jsp.tagext.BodyTag;
import jakarta.servlet.jsp.tagext.Tag;


public class ShowDateWithCaseTag implements BodyTag {
	
	@SuppressWarnings("unused")
	private PageContext pageContext = null;
    private Tag parentTag = null;
    private BodyContent bodyContent = null;
    private boolean showInUpperCase;
    
    public boolean isShowInUpperCase() {
    	return showInUpperCase;
    }
    
    public void setShowInUpperCase(boolean showInUpperCase) {
        this.showInUpperCase = showInUpperCase;
    }
    
	@Override
	public int doAfterBody() throws JspException {
		try {
			
            String bodyString = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();

      	    out.println("--- Début du ShowDateWithCaseTag ---");
      	  
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy EEEE");
			
            if (showInUpperCase) {
                out.print((bodyString + sdf.format(new Date())).toUpperCase());
		    } else {
                out.print((bodyString + sdf.format(new Date())).toLowerCase());
            }

      	    out.println("--- Fin du ShowDateWithCaseTag ---");
      	  
            bodyContent.clear(); // empty buffer for next evaluation
            
		} catch (IOException e) {
            e.printStackTrace();
        }

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_AGAIN;
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

	@Override
	public void doInitBody() throws JspException {
		// Nothing ToDo	NOSONAR	
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;		
	}
}
