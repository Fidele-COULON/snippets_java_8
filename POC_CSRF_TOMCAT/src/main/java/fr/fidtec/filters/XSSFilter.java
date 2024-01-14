package fr.fidtec.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

// https://stackoverflow.com/questions/2811769/adding-an-http-header-to-the-request-in-a-servlet-filter
public class XSSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {	
		System.out.println("Passage par XSSFilter");
		chain.doFilter(new DetectXSSWrapper((HttpServletRequest) request), response);
	}

}
