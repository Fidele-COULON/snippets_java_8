package fr.fidtec.samples;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class RunMe {
	
    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;

	@Parameter(names = "-loglevel", description = "Level of verbosity")
	private Integer logLevel = 1;

	@Parameter(names = "-password", description = "Connection password", password = true) // echoInput = true
	private String password;
	
    public static void main(String ... argv) {
    	
    	RunMe main = new RunMe();
        
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        
        main.run();
    }

    public void run() {
        System.out.printf("length=%b - logLevel=%d", debug, logLevel);
    }
    
}
