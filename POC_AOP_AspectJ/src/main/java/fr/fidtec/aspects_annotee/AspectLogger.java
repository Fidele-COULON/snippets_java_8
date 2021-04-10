package fr.fidtec.aspects_annotee;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// execution d'AspectJ sur les méthodes main uniquement (doit aussi être configuré dans le fichier de conf aop.xml) 
// Les annotations ne sont qu'une simplification de déclaration 

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
