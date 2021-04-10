
package fr.fidtec.appenders;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;

@Plugin(name="MyCustomAppender", category= Core.CATEGORY_NAME, elementType= Appender.ELEMENT_TYPE, printObject=true)
public class MyCustomImpl extends AbstractAppender {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();

    protected MyCustomImpl(String name, Filter filter, Layout<? extends Serializable> layout, final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }
    
    @PluginFactory
    public static MyCustomImpl createAppender(
            @PluginAttribute("name") String name,
            @PluginAttribute("port") String port,
            @PluginAttribute("format") String format,
            @PluginAttribute("host") String host,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttribute) {
 
    	if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImp");
            return null;
        }
    	
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        
        return new MyCustomImpl(name, filter, layout, true);

    }
    
    @Override
    public void append(LogEvent event) {
    	readLock.lock();
        try {    
        	final byte[] bytes = getLayout().toByteArray(event);
            System.out.print("LOG: " + new String(bytes, StandardCharsets.UTF_8)); 	// here I am printing logs into console
        } catch (Exception ex) {
        	if (!ignoreExceptions()) {
        		throw new AppenderLoggingException(ex);
        	}
        } finally {
        	readLock.unlock();
       }
    }
}
