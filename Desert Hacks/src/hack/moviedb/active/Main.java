package hack.moviedb.active;

import java.io.*;
import java.net.*;
import java.util.*;

import hack.moviedb.data.Movie;
import hack.moviedb.data.Person;
import hack.moviedb.web.WebTalker;

/**
 * @author Aaron
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// System.out.print("Movie name: ");
		// System.out.print("Person name: ");

		// String input = scanner.nextLine();
		String details = "";
		String credits = "";
		String configData = "";

		try {
			configData = WebTalker.retrieveConfiguration();
//			JsonParser.parseConfigData(configData);
//			// WebTalker.searchForMovie(input);
//			details = WebTalker.getMovieDetails(343611);
//			credits = WebTalker.getMovieCredits(343611);
//			Movie aMovie = JsonParser.parseMovie(details, credits);
//			// WebTalker.searchForPerson(input);
//			details = WebTalker.getPersonDetails(500);
//			credits = WebTalker.getPersonCredits(500);
//			Person aPerson = JsonParser.parsePerson(details, credits);
			
			
//			System.out.println(aPerson.getPersonHead().getProfileImageURL());
//			System.out.println(aMovie.getMovieHead().getPosterImageURL());

		} catch (Exception e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}