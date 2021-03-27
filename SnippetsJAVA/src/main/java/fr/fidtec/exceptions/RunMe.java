package fr.fidtec.exceptions;

public class RunMe {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		try {
			BeanWithException beanWithException1 = new BeanWithException("TOTO");
			BeanWithException beanWithException2 = new BeanWithException("COULON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
