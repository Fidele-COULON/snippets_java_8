package fr.fidtec.listeners;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class CSRFHttpSessionListener implements HttpSessionListener {

	 @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("-- HttpSessionListener#sessionCreated invoked --");
        HttpSession session = se.getSession();
        session.setAttribute(CSRF_Utils.CSRF_TOKEN, CSRF_Utils.generateCSRFToken());
        System.out.println("session id: " + session.getId());
        session.setMaxInactiveInterval(5);//in seconds
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("-- HttpSessionListener#sessionDestroyed invoked --");
    }
	    
}
