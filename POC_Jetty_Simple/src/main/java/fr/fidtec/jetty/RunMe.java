package fr.fidtec.jetty;

import org.eclipse.jetty.server.Server;

public class RunMe {

	public static void main(String[] args) throws Exception  {
        Server server = new Server(8181);
        server.setHandler(new HelloWorldJettyHandler());
 
        server.start();
        server.join();
    }
}
