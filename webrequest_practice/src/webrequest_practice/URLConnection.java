package webrequest_practice;

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;


public abstract class URLConnection {
	
	
	
	private static String readAll(Reader rd) throws IOException {
	StringBuilder sb = new StringBuilder();
	int cp;
	while((cp = rd.read()) != -1) {
		sb.append((char) cp);
	}
	return sb.toString().trim();
	}
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException{
	InputStream is = new URL(url).openStream();
	try {
		BufferedReader rd =  new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String jsonText = readAll(rd);
		JSONObject json = new JSONObject(jsonText.trim());
		return json;
		

	}finally {
		is.close();
	}
	}

	public static void main(String[]args) throws IOException, JSONException{
		
		JSONObject json = readJsonFromUrl("https://jsonplaceholder.typicode.com/users");
		System.out.println(json.toString().trim());
		System.out.println(json.get("id"));
	}
}
	

