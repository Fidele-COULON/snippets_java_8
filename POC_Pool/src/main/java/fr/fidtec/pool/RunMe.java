package fr.fidtec.pool;

public class RunMe {

	public static void main(String[] args) {
		
		try {
		ObjectInPool o1 = Pool_ObjectInPool.getObj();
		System.out.println(o1.getInstance() + " - " + Pool_ObjectInPool.getStatut());
		
		ObjectInPool o2 = Pool_ObjectInPool.getObj();
		System.out.println(o2.getInstance() + " - " + Pool_ObjectInPool.getStatut());

		Pool_ObjectInPool.returnObj(o1);
		
		System.out.println(Pool_ObjectInPool.getStatut());
		
		for (int i=0; i < 15; i++) {
			System.out.println("Itération :" + i);
			ObjectInPool o = Pool_ObjectInPool.getObj();
			if (o == null ) {
				System.out.println("Itération :" + i + " - Instance null");
			} else {
				System.out.println("Itération :" + i + " - " + o.getInstance() + " - " + Pool_ObjectInPool.getStatut());
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
