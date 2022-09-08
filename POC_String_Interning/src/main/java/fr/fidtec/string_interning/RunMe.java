package fr.fidtec.string_interning;

public class RunMe {

	public static void main(String[] args) {
		
		// !!!! CASE #1
		// When a string is created in Java, it occupies memory in the heap
		// Also, we know that the String class is immutable.
		// Therefore, whenever we create a string using the new keyword, new memory is allocated in the heap for
		// corresponding string, which is irrespective of the content of the array.
		// Whenever we create a String object using the new keyword, two objects are created.
		// Here, one object is created in the heap memory outside of the SCP because of the usage of the new keyword.
	    String str1 = new String("Welcome to FIDTEC !"); // NOSONAR  
	    String str2 = new String("Welcome to FIDTEC !");  // NOSONAR 
	    
	    // The println statement prints false because separate memory is allocated for each string literal.
	    System.out.println("Case #1 : " + (str2 == str1)); // prints false NOSONAR
	    
	    
	    // !!!! CASE #2
	    // A string literal always invokes the intern() method, whether one mention the intern() method along with the string literal or not.
	    String str3 = "Welcome to FIDTEC !";   
	    String str4a = "Welcome to FIDTEC !"; 
	    String str4b = "Welcome to FIDTEC !".intern();  
	    System.out.println("Case #2a : " + (str3 == str4a));  // prints true NOSONAR
	    System.out.println("Case #2b : " + (str4a == str4b)); // prints true NOSONAR
	    
	    // !!!! CASE #3
	    // We know that creating an object is a costly operation in Java.
	    // Therefore, to save time, Java developers came up with the concept of String Constant Pool (SCP).
	    // The SCP is an area inside the heap memory. It contains the unique strings.
	    // In order to put the strings in the string pool, one needs to call the intern() method.
	    // Before creating an object in the string pool, the JVM checks whether the string is already present in the pool or not.
	    // If the string is present, its reference is returned.
	    
	    // The intern() method is invoked on the String objects. Therefore, the memory is allocated in the SCP.
	    // For the second statement, no new string object is created as the content of str5 and str6 are the same.
	    // Therefore, the reference of the object created in the first statement is returned for str6.
	    // Thus, str5 and str6 both point to the same memory. Hence, the print statement prints true.
	    String str5 = new String("Welcome to FIDTEC !").intern(); // NOSONAR  
	    String str6 = new String("Welcome to FIDTEC !").intern();  // NOSONAR 
	    System.out.println("Case #3 : " + (str5 == str6)); // prints true NOSONAR
	    
	}

}
