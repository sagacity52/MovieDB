package hack.moviedb.active;

import java.io.*;
import java.net.*;
import java.util.*;

import hack.moviedb.data.Movie;
import hack.moviedb.web.WebTalker;

/**
 * @author Aaron
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//System.out.print("URL: ");
		System.out.print("Movie name: ");
		
		String input = scanner.nextLine();
		String result = "";
				
		try
		{
			result = WebTalker.getHTML(input, "movie");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
}