package fr.fidtec.POC_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RunMe {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Customer.xml" });
		
		try {
		
			CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy");
	
			System.out.println("*************************");
			cust.printName();
			System.out.println("*************************");
			cust.printURL();
			System.out.println("*************************");
		
			cust.printThrowException();
			
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		} finally {
			((ClassPathXmlApplicationContext) appContext).close();
		}
	}
}