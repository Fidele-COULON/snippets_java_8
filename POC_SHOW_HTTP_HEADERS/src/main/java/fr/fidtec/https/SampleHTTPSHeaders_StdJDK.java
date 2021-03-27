package fr.fidtec.https;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import fr.fidtec.http.Constants;

public class SampleHTTPSHeaders_StdJDK {

	public static void main(String[] args) {
		
		try {
			
			URL url = new URL(Constants.URL_HTTPS);		

			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(); // HTTPS
	
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
			
			System.out.println("CipherSuite : " + connection.getCipherSuite());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
