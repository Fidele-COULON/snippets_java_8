package fr.fidtec.http;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SampleHTTPHeaders_StdJDK {

	public static void main(String[] args) {
		
		try {
			
			URL url = new URL(Constants.URL);		
			URLConnection connection = url.openConnection(); // HTTP
	
			// Get all headers
			Map<String, List<String>> headers = connection.getHeaderFields();			
			
			for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " - Value : " + entry.getValue());
			}

			// Get header by 'key'
			String headerServer = connection.getHeaderField("Server");
			if (null != headerServer) {
				System.out.println("Server = " + headerServer);
			} else {
				System.out.println("Server non trouvé");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
