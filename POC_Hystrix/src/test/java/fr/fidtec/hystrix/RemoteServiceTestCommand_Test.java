  package fr.fidtec.hystrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.exception.HystrixRuntimeException;


// https://www.baeldung.com/introduction-to-hystrix
public class RemoteServiceTestCommand_Test {

	@Test
	public void givenSvcTimeoutOf100AndDefaultSettings_whenRemoteSvcExecuted_thenReturnSuccess() throws InterruptedException {

		Setter config = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup"));
	    
	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(100)).execute());
	}
	
	@Test
	public void givenSvcTimeoutOf5000AndExecTimeoutOf10000_whenRemoteSvcExecuted_thenReturnSuccess() throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupTest2"));

	    HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
	    commandProperties.withExecutionTimeoutInMilliseconds(10_000);
	    config.andCommandPropertiesDefaults(commandProperties);

	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute());
	}
	
	@Test(expected = HystrixRuntimeException.class)
	public void givenSvcTimeoutOf15000AndExecTimeoutOf5000_whenRemoteSvcExecuted_thenExpectHre()
	  throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupTest3"));

	    HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
	    commandProperties.withExecutionTimeoutInMilliseconds(5_000);
	    config.andCommandPropertiesDefaults(commandProperties);

	    new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(15_000)).execute();
	    
	    // lève une erreur com.netflix.hystrix.exception.HystrixRuntimeException: RemoteServiceTestCommand timed-out and no fallback available.
	}
	
	@Test
	public void givenSvcTimeoutOf500AndExecTimeoutOf10000AndThreadPool_whenRemoteSvcExecuted_thenReturnSuccess() throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupThreadPool"));

	    HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
	    
	    commandProperties.withExecutionTimeoutInMilliseconds(10_000);
	    config.andCommandPropertiesDefaults(commandProperties);
	    
	    config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
	      .withMaxQueueSize(10)
	      .withCoreSize(3)
	      .withQueueSizeRejectionThreshold(10));

	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute());
	}
	
	@Test
	public void givenCircuitBreakerSetup_whenRemoteSvcCmdExecuted_thenReturnSuccess() throws InterruptedException {

	    HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupCircuitBreaker"));

	    HystrixCommandProperties.Setter properties = HystrixCommandProperties.Setter();
	    properties.withExecutionTimeoutInMilliseconds(1000);
	    properties.withCircuitBreakerSleepWindowInMilliseconds(4000);
	    properties.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
	    properties.withCircuitBreakerEnabled(true);
	    properties.withCircuitBreakerRequestVolumeThreshold(1);

	    config.andCommandPropertiesDefaults(properties);
	    config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
	      .withMaxQueueSize(1)
	      .withCoreSize(1)
	      .withQueueSizeRejectionThreshold(1));

	    assertNull(this.invokeRemoteService(config, 10_000));
	    assertNull(this.invokeRemoteService(config, 10_000));
	    assertNull(this.invokeRemoteService(config, 10_000));

	    Thread.sleep(5000); // NOSONAR

	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute());
	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute());
	    assertEquals("Success", new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute());
	}
	
	public String invokeRemoteService(HystrixCommand.Setter config, int timeout) throws InterruptedException {

	    String response = null;

	    try {
	        response = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(timeout)).execute();
	    } catch (HystrixRuntimeException ex) {
	        System.out.println("ex = " + ex);
	    }

	    return response;
	}
}
