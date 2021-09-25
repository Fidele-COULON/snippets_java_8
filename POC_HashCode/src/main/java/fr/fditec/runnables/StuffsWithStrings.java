package fr.fditec.runnables;

public class StuffsWithStrings {

	public static void main(String[] args) {
		 String s1 = new String("hello");
		 String s2 = new String("hello");
		 
		 System.out.println("HashCode of s1 : " + s1.hashCode());
		 System.out.println("HashCode of s2 : " + s2.hashCode());
		 
		 String s3 = "hello";
		 String s4 = "hello";
		 
		 System.out.println("HashCode of s3 : " + s3.hashCode());
		 System.out.println("HashCode of s4 : " + s4.hashCode());
	}
}
