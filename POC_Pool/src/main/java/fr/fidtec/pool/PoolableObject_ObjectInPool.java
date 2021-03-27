package fr.fidtec.pool;

import nf.fr.eraasoft.pool.PoolException;
import nf.fr.eraasoft.pool.PoolableObject;

public class PoolableObject_ObjectInPool implements PoolableObject<ObjectInPool> {
	int count = 0;
	
	// is called whenever a new instance is needed. 
	public ObjectInPool make() throws PoolException {
		System.out.println("make Instance:" + count);
		count ++;
		return new ObjectInPool("Instance:" + count);
	}

	// is invoked on activated instances to make sure they can be borrowed (sorti) from the pool.
	// validateObject may also be used to test an instance being returned to the pool before it is passivated.
	public boolean validate(ObjectInPool t) {
		System.out.println("validate Instance:" + t.getInstance());
		return false;
	}

	// is invoked on every instance when it is being "dropped" from the pool (whether due to the response from validateObject,
	// or for reasons specific to the pool implementation.)
	public void destroy(ObjectInPool t) {
		System.out.println("destroy Instance:" + t.getInstance());
	}

	// is invoked on every instance that has been passivated before it is borrowed from the pool. 
	public void activate(ObjectInPool t) throws PoolException {
		System.out.println("activate Instance:" + t.getInstance());
	}

	// is invoked on every instance when it is returned to the pool.
	public void passivate(ObjectInPool t) {
		System.out.println("passivate Instance:" + t.getInstance());
	}
}
