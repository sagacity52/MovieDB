package hack.moviedb.active;

import hack.moviedb.data.*;
import java.util.LinkedList;
import java.util.List;

import org.json.*;

public class JsonParser {
	private static String base_url = null;
	private static String[] poster_sizes = null;
	private static String[] profile_sizes = null;

	// Config
	public static boolean parseConfigData(String configData) {
		boolean toReturn = false;

		JSONObject obj = new JSONObject(configData);

		base_url = obj.getJSONObject("images").getString("base_url");
		System.out.println(base_url);

		JSONArray posterSizes = obj.getJSONObject("images").getJSONArray("poster_sizes");
		List<Object> posList = posterSizes.toList();
		poster_sizes = posList.toArray(new String[posList.size()]);

		JSONArray profileSizes = obj.getJSONObject("images").getJSONArray("profile_sizes");
		List<Object> profList = profileSizes.toList();
		profile_sizes = profList.toArray(new String[profList.size()]);

		toReturn = true;
		return toReturn;
	}

	// Images
	public static String generatePosterImageURL(String imagePath, int size) {
		if (imagePath == null || base_url == null || poster_sizes == null)
			return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Middle_finger_BNC.jpg/250px-Middle_finger_BNC.jpg";
		else {
			if (size >= poster_sizes.length || size == -1) {
				System.out.println("Size choice out of bounds, using default");
				return base_url + poster_sizes[poster_sizes.length - 1] + imagePath;
			} else

				return base_url + poster_sizes[size] + imagePath;
		}

	}

	public static String generatePosterThumbnailURL(String imagePath) {
		if (imagePath == null || base_url == null || poster_sizes == null)
			return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Middle_finger_BNC.jpg/250px-Middle_finger_BNC.jpg";
		else
			return base_url + poster_sizes[0] + imagePath;
	}

	public static String generateProfileImageURL(String imagePath, int size) {
		if (imagePath == null || base_url == null || profile_sizes == null)
			return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Middle_finger_BNC.jpg/250px-Middle_finger_BNC.jpg";
		else {
			if (size >= profile_sizes.length || size == -1) {
				System.out.println("Size choice out of bounds, using default");
				return base_url + profile_sizes[profile_sizes.length - 1] + imagePath;
			} else

				return base_url + profile_sizes[size] + imagePath;
		}

	}

	public static String generateProfileThumbnailURL(String imagePath) {
		if (imagePath == null || base_url == null || profile_sizes == null)
			return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Middle_finger_BNC.jpg/250px-Middle_finger_BNC.jpg";
		else
			return base_url + profile_sizes[0] + imagePath;
	}

	// Movie Parsing
	public static MovieHeader[] parseMovieSearchResults(String data) {
		LinkedList<MovieHeader> list = new LinkedList<MovieHeader>();

		JSONObject obj = new JSONObject(data);

		JSONArray arr = obj.getJSONArray("results");

		int i = 0;
		while (i < arr.length() && i < 10) {
			String title = arr.getJSONObject(i).getString("title");

			int id = arr.getJSONObject(i).getInt("id");

			String imagePath = null;
			try {
				imagePath = arr.getJSONObject(i).getString("poster_path");
			} catch (Exception e) {
				imagePath = null;
			}
			String imageURL = generatePosterThumbnailURL(imagePath);

			MovieHeader toAdd = new MovieHeader(title, id, imageURL);
			list.add(toAdd);
			System.out.println(String.format("%s %s %s", title, Integer.toString(id), imageURL));
			i++;
		}

		MovieHeader[] toReturn = list.toArray(new MovieHeader[list.size()]);
		return toReturn;
	}

	public static Movie parseMovie(String details, String credits) {
		Movie toReturn = null;

		int movieID = -1;
		String imagePath = "";
		String imageURL = "";
		String ogTitle = "";
		String releaseDate = "";
		LinkedList<String> genres = new LinkedList<String>();
		String overview = "";
		boolean isAdult = false;
		String prodCo = "";
		LinkedList<PersonHeader> castList = new LinkedList<PersonHeader>();
		LinkedList<PersonHeader> crewList = new LinkedList<PersonHeader>();

		// getDetails
		JSONObject detailObj = new JSONObject(details);

		isAdult = detailObj.getBoolean("adult");
		System.out.println(Boolean.toString(isAdult));

		JSONArray genreArr = detailObj.getJSONArray("genres");
		for (int i = 0; i < genreArr.length(); i++) {
			String genreToAdd = genreArr.getJSONObject(i).getString("name");
			System.out.println(genreToAdd);
			genres.add(genreToAdd);
		}

		movieID = detailObj.getInt("id");
		System.out.println(movieID);

		overview = detailObj.getString("overview");
		System.out.println(overview);

		try {
			imagePath = detailObj.getString("poster_path");
		} catch (Exception e) {
			imagePath = null;
		}
		imageURL = generatePosterImageURL(imagePath, -1);
		System.out.println(imageURL);

		JSONArray prodArr = detailObj.getJSONArray("production_companies");
		prodCo = prodArr.getJSONObject(0).getString("name");
		System.out.println(prodCo);

		releaseDate = detailObj.getString("release_date");
		System.out.println(releaseDate);

		ogTitle = detailObj.getString("title");
		System.out.println(ogTitle);

		// getCredits
		JSONObject creditObj = new JSONObject(credits);

		JSONArray castArr = creditObj.getJSONArray("cast");
		for (int i = 0; i < castArr.length(); i++) {
			String castName = castArr.getJSONObject(i).getString("name");
			int castID = castArr.getJSONObject(i).getInt("id");
			String characterName = castArr.getJSONObject(i).getString("character");
			String profilePath = null;
			try {
				profilePath = castArr.getJSONObject(i).getString("profile_path");
			} catch (Exception e) {
				profilePath = null;
			}
			String profileURL = generateProfileThumbnailURL(profilePath);
			System.out.println(castName);
			System.out.println(Integer.toString(castID));
			System.out.println(characterName);
			System.out.println(profileURL);
			PersonHeader personToAdd = new PersonHeader(castName, castID, characterName, profileURL);
			castList.add(personToAdd);
		}

		JSONArray crewArr = creditObj.getJSONArray("crew");
		for (int i = 0; i < crewArr.length(); i++) {
			String crewName = crewArr.getJSONObject(i).getString("name");
			int crewID = crewArr.getJSONObject(i).getInt("id");
			String job = crewArr.getJSONObject(i).getString("job");
			String profilePath = null;
			try {
				profilePath = crewArr.getJSONObject(i).getString("profile_path");
			} catch (Exception e) {
				profilePath = null;
			}
			String profileURL = generateProfileThumbnailURL(profilePath);
			System.out.println(crewName);
			System.out.println(Integer.toString(crewID));
			System.out.println(job);
			System.out.println(profileURL);
			PersonHeader personToAdd = new PersonHeader(crewName, crewID, job, profileURL);
			castList.add(personToAdd);
		}

		MovieHeader header = new MovieHeader(ogTitle, movieID, imageURL);
		toReturn = new Movie(header, releaseDate, genres.toArray(new String[genres.size()]), overview, isAdult, prodCo,
				castList.toArray(new PersonHeader[castList.size()]),
				crewList.toArray(new PersonHeader[crewList.size()]));

		return toReturn;
	}

	// Person Parsing
	public static PersonHeader[] parsePersonSearchResults(String data) {
		LinkedList<PersonHeader> list = new LinkedList<PersonHeader>();

		JSONObject obj = new JSONObject(data);

		JSONArray arr = obj.getJSONArray("results");

		int i = 0;
		while (i < arr.length() && i < 10) {
			String title = arr.getJSONObject(i).getString("name");

			int id = arr.getJSONObject(i).getInt("id");

			String imagePath = null;
			try {
				imagePath = arr.getJSONObject(i).getString("profile_path");
			} catch (Exception e) {
				imagePath = null;
			}
			String imageURL = generatePosterThumbnailURL(imagePath);

			PersonHeader toAdd = new PersonHeader(title, id, imageURL);
			list.add(toAdd);
			System.out.println(String.format("%s %s %s", title, Integer.toString(id), imageURL));
			i++;
		}

		PersonHeader[] toReturn = list.toArray(new PersonHeader[list.size()]);
		return toReturn;
	}

	public static Person parsePerson(String details, String credits) {
		Person toReturn = null;

		String name = "";
		int id = -1;
		String imagePath = "";
		String imageURL = "";
		String bday = "";
		String dday = "";
		String gender = "";
		String bio = "";
		String birthplace = "";
		LinkedList<MovieHeader> starredList = new LinkedList<MovieHeader>();
		LinkedList<MovieHeader> crewedList = new LinkedList<MovieHeader>();

		// getDetails
		JSONObject detailObj = new JSONObject(details);

		bio = detailObj.getString("biography");
		System.out.println(bio);

		bday = detailObj.getString("birthday");
		System.out.println(bday);

		dday = detailObj.getString("deathday");
		System.out.println(dday);

		int g = detailObj.getInt("gender");
		if (g == 1)
			gender = "Female";
		else if (g == 2)
			gender = "Male";
		System.out.println(gender);

		id = detailObj.getInt("id");
		System.out.println(Integer.toString(id));

		name = detailObj.getString("name");
		System.out.println(name);

		birthplace = detailObj.getString("place_of_birth");
		System.out.println(birthplace);

		try {
			imagePath = detailObj.getString("profile_path");
		} catch (Exception e) {
			imagePath = null;
		}
		imageURL = generatePosterImageURL(imagePath, -1);
		System.out.println(imageURL);

		// getCredits
		JSONObject creditObj = new JSONObject(credits);

		JSONArray castArr = creditObj.getJSONArray("cast");
		for (int i = 0; i < castArr.length(); i++) {
			String movieName = castArr.getJSONObject(i).getString("title");
			int movieID = castArr.getJSONObject(i).getInt("id");
			String characterName = castArr.getJSONObject(i).getString("character");
			String posterPath = null;
			try {
				posterPath = castArr.getJSONObject(i).getString("poster_path");
			} catch (Exception e) {
				posterPath = null;
			}
			String posterURL = generatePosterThumbnailURL(posterPath);
			System.out.println(movieName);
			System.out.println(Integer.toString(movieID));
			System.out.println(characterName);
			System.out.println(posterURL);
			MovieHeader movieToAdd = new MovieHeader(movieName, movieID, characterName, posterURL);
			starredList.add(movieToAdd);
		}

		JSONArray crewArr = creditObj.getJSONArray("crew");
		for (int i = 0; i < crewArr.length(); i++) {
			String movieName = crewArr.getJSONObject(i).getString("title");
			int movieID = crewArr.getJSONObject(i).getInt("id");
			String job = crewArr.getJSONObject(i).getString("job");
			String posterPath = null;
			try {
				posterPath = crewArr.getJSONObject(i).getString("poster_path");
			} catch (Exception e) {
				posterPath = null;
			}
			String posterURL = generatePosterThumbnailURL(posterPath);
			System.out.println(movieName);
			System.out.println(Integer.toString(movieID));
			System.out.println(job);
			System.out.println(posterURL);
			MovieHeader movieToAdd = new MovieHeader(movieName, movieID, job, posterURL);
			crewedList.add(movieToAdd);
		}

		PersonHeader header = new PersonHeader(name, id, imageURL);
		toReturn = new Person(header, bday, dday, gender, bio, birthplace,
				starredList.toArray(new MovieHeader[starredList.size()]),
				crewedList.toArray(new MovieHeader[crewedList.size()]));

		return toReturn;
	}
}