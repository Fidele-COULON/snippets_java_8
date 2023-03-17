package fr.fidtec.pool;

import org.junit.Test;

public class PoolOfObjectInPool_Test {

	private static final int MAX_INTERATION = 15;
	
	@Test
	public void Pool_Test() {
		
		try {
			
			ObjectInPool obj1 = PoolOfObjectInPool.getObj();
			System.out.println(obj1.getInstance() + " - " + PoolOfObjectInPool.getStatut());
			
			ObjectInPool obj2 = PoolOfObjectInPool.getObj();
			System.out.println(obj2.getInstance() + " - " + PoolOfObjectInPool.getStatut());
		
			PoolOfObjectInPool.returnObj(obj1);
			System.out.println(PoolOfObjectInPool.getStatut());
			
			for (int i=0; i < MAX_INTERATION; i++) {
				
				System.out.println("Iteration :" + i);
				ObjectInPool obj = PoolOfObjectInPool.getObj();
				if (obj == null ) {
					System.out.println("Iteration :" + i + " - Instance null");
				} else {
					System.out.println("Iteration :" + i + " - " + obj.getInstance() + " - " + PoolOfObjectInPool.getStatut());
				}
			}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
