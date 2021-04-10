package fr.fidtec.aspects;

// execution d'AspectJ sur les méthodes non statics public
// il est activé par le fichier de conf aop.xml 

public aspect CompteurAspect {

    pointcut publicMethodExecuted(): execution(public !static * *(..));

 	before(): publicMethodExecuted() {
 		System.out.printf("CompteurAspect - Before on method : %s. \n", thisJoinPoint.getSignature());
 	}
 
    after(): publicMethodExecuted() {
    
        System.out.printf("CompteurAspect - After on method: %s. \n", thisJoinPoint.getSignature());

        Object[] arguments = thisJoinPoint.getArgs();
        
        for (int i =0; i < arguments.length; i++){
            Object argument = arguments[i];
            
            if (argument != null) {
                System.out.printf("With argument of type %s and value %s. \n", argument.getClass().toString(), argument);
            }
        }
        
    }
    
}