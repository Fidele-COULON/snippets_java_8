package fr.fidtec.POC_AOP_With_Springframework;

public class CustomerService {
	private String name;
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void printName() {
		System.out.println("Mon nom : " + this.name);
	}

	public void printURL() {
		System.out.println("Mon site WEB : " + this.url);
	}

	public void printThrowException() throws Exception {
		// throw new IllegalArgumentException();
		throw new Exception("printThrowException");
	}

}
