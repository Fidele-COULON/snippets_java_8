package fr.fidtec.http;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class SampleHTTPHeaders_ApacheHttpClient {

	public static void main(String[] args) {
				
		try {
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(Constants.URL);
			HttpResponse response = client.execute(request);
				
			// Get all headers
			Header[] headers = response.getAllHeaders();
			for (Header header : headers) {
				System.out.println("Key : " + header.getName() + " - Value : " + header.getValue());
			}
	
			//get header by 'key'
			Header headerServer = response.getFirstHeader("Server");
			if (null != headerServer) {
				System.out.println("Server = " + headerServer.getValue());
			} else {
				System.out.println("Server non trouvé");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
