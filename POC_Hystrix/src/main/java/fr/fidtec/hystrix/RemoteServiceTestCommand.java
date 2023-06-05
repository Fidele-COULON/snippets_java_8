package fr.fidtec.hystrix;

import com.netflix.hystrix.HystrixCommand;

public class RemoteServiceTestCommand extends HystrixCommand<String> {

	private RemoteServiceTestSimulator remoteService;

    public RemoteServiceTestCommand(Setter config, RemoteServiceTestSimulator remoteService) {
        super(config);
        this.remoteService = remoteService;
    }

    @Override
    protected String run() throws Exception {
        return remoteService.execute();
    }
	    
}
