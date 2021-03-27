package fr.fidtec.exceptions;

public class BeanWithException {
	private String name;
	
	public BeanWithException(String name) throws Exception {
		if ("COULON".equals(name)) {
			throw new Exception("Nom connu");
		} else {
			this.name =name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
