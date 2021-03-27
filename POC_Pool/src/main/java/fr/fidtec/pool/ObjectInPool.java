package fr.fidtec.pool;

public class ObjectInPool {
	private String Instance = null;

	public String getInstance() {
		return Instance;
	}

	public void setInstance(String instance) {
		Instance = instance;
	}

	public ObjectInPool(String instance) {
		super();
		Instance = instance;
	}
}
