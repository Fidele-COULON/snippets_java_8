package fr.fidtec.POC_AOP_With_Springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RunMe {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Customer.xml" });
		
		try {
		
			CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy");
	
			System.out.println("*************************"); //NOSONAR
			cust.printName();
			System.out.println("*************************"); //NOSONAR
			cust.printURL();
			System.out.println("*************************"); //NOSONAR
		
			cust.printThrowException();
			
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage()); //NOSONAR
		} finally {
			((ClassPathXmlApplicationContext) appContext).close();
		}
	}
}