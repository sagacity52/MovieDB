package hack.moviedb.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class WebTalker {
	private static final String API_KEY = "6c4fd1c4633cdb03a5ac141a62b616a9";

	// Images
	public static String retrieveConfiguration() {
		StringBuilder result = new StringBuilder();

		try {
			String input = String.format("https://api.themoviedb.org/3/configuration?api_key=%s", API_KEY);

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
		} catch (Exception e) {
			return null;
		}

		return result.toString();
	}

	// Movie Queries
	public static String searchForMovie(String query) throws Exception {
		StringBuilder result = new StringBuilder();

		try {
			String input = String.format("https://api.themoviedb.org/3/search/movie?api_key=%s&query=%s", API_KEY,
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
		} catch (Exception e) {
			return null;
		}

		return result.toString();
	}

	public static String getMovieDetails(int movieID) throws Exception {
		StringBuilder result = new StringBuilder();

		String input = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s", Integer.toString(movieID),
				API_KEY);
		try {
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

		} catch (Exception e) {
			return null;
		}

		return result.toString();
	}

	public static String getMovieCredits(int movieID) throws Exception {
		StringBuilder result = new StringBuilder();

		try {
			String input = String.format("http://api.themoviedb.org/3/movie/%s/credits?api_key=%s",
					Integer.toString(movieID), API_KEY);

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
		} catch (Exception e) {
			return null;
		}
		return result.toString();
	}

	// Person Queries
	public static String searchForPerson(String query) throws Exception {
		StringBuilder result = new StringBuilder();

		try {
			String input = String.format("https://api.themoviedb.org/3/search/person?api_key=%s&query=%s", API_KEY,
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
		} catch (Exception e) {
			return null;
		}

		return result.toString();
	}

	public static String getPersonDetails(int personID) throws Exception {
		StringBuilder result = new StringBuilder();

		String input = String.format("https://api.themoviedb.org/3/person/%s?api_key=%s", Integer.toString(personID),
				API_KEY);
		try {
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

		} catch (Exception e) {
			return null;
		}

		return result.toString();
	}

	public static String getPersonCredits(int personID) throws Exception {
		StringBuilder result = new StringBuilder();

		try {
			String input = String.format("http://api.themoviedb.org/3/person/%s/movie_credits?api_key=%s",
					Integer.toString(personID), API_KEY);

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
		} catch (Exception e) {
			return null;
		}
		return result.toString();
	}
}