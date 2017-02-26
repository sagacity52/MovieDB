package hack.moviedb.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class WebTalker {
	private static final String API_KEY = "6c4fd1c4633cdb03a5ac141a62b616a9";

	public static String getHTML(String query, String type) throws Exception {
		StringBuilder result = new StringBuilder();

		String input = String.format("https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s", type, API_KEY,
				URLEncoder.encode(query, "UTF-8"));

		URL url = new URL(input);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
			System.out.println(line);
		}
		rd.close();

		return result.toString();
	}
}