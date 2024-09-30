package fr.fidtec.log4j2;

import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;

// use -Dlog4j2.configurationFactory=fr.fidtec.Log4j2.CustomConfigFactory

public class CustomConfigFactory extends ConfigurationFactory {

	@Override
	protected String[] getSupportedTypes() {
		 return new String[] {"*"};
	}

	@Override
	public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
		// ConfigurationBuilder<BuiltConfiguration> builder = super.newConfigurationBuilder();
	    // return builder.build();
		
		ThreadContext.put("os", "windows2");
        
        return new XmlConfiguration(loggerContext, source);
	}

}
