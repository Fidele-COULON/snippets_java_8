package fr.fidtec.filters;

import jakarta.servlet.Filter;

public abstract class AbstractFidtecFilter implements Filter {

	protected abstract void doSomething();
}
