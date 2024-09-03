package fr.fidtec.filters;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
 
public class LogFilterSimple1 extends AbstractFidtecFilter {
  
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println(LogFilterSimple1.class.getSimpleName() + " init !!"); //NOSONAR
    }
 
    @Override
    public void destroy() {
        System.out.println(LogFilterSimple1.class.getSimpleName() + " destroy !!"); //NOSONAR
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
 
        String servletPath = req.getServletPath();
 
        System.out.println("#INFO : " + new Date() + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL()); //NOSONAR
 
        doSomething();
        
        // Passez à l'élément suivant (filtre ou cible) en chaîne.
        chain.doFilter(request, response);
        
        System.out.println("Après le chain de " + LogFilterSimple1.class.getSimpleName()); //NOSONAR
    }

	@Override
	protected void doSomething() {
		System.out.println("doSomething ..."); //NOSONAR
	}
    
    
 
}
