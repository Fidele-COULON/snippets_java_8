package fr.fidtec.listeners;


import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CSRFServletListener implements ServletRequestListener {

	  @Override
	  public void requestInitialized(ServletRequestEvent sre) {
		  System.out.println("ServletRequestInitialized : " + sre.getServletContext());		  
	  }

	  @Override
	  public void requestDestroyed(ServletRequestEvent sre) {
		  System.out.println("ServletRequestDestroyed : " + sre.getServletContext());
	  }
}
