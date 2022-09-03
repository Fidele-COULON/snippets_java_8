package fr.fidtec.SnippetsJAVA;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Object obj = Class.forName("fr.fidtec.SnippetsJAVA.User").getDeclaredConstructor().newInstance();
		
		Method method1 = obj.getClass().getMethod("setNom", java.lang.String.class);
		method1.invoke(obj, "COULON");
		
		Method method2 = obj.getClass().getMethod("setPrenom", java.lang.String.class);
		method2.invoke(obj, "Fidele");
		System.out.println(obj);
		
		// java.lang.ClassNotFoundException
		Object obj2 = Class.forName("fr.fidtec.SnippetsJAVA.User2").getDeclaredConstructor().newInstance();
	}

}
