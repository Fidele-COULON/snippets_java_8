package fr.fidtec.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//execution d'AspectJ sur les méthodes main uniquement (pas de conf dans le fichier aop.xml car annotations 

@Aspect
public class AspectLogger {

	@Pointcut("execution(* main(..))")
    public void defineEntryPoint() { //NOSONAR
    }

    @Before("defineEntryPoint()")
    public void aaa(JoinPoint joinPoint) {
        System.out.println("AspectLogger - Before"); //NOSONAR
    }

    @After("defineEntryPoint()")
    public void bbb(JoinPoint joinPoint) {
        System.out.println("AspectLogger - After"); //NOSONAR
    }
    
}
