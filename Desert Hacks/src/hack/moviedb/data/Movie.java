package hack.moviedb.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Movie {

	// getDetails
	private MovieHeader movieHead;
	private StringProperty releaseDate;
	private String[] genres;
	private String overview;
	private boolean isAdult;
	private String prodCo;

	// getCredits
	private PersonHeader[] castList;
	private PersonHeader[] crewList;

	
	public Movie(MovieHeader m, String r, String[] g, String o, boolean a, String p, PersonHeader[] cast,
			PersonHeader[] crew) {
		movieHead = m;
		releaseDate = new SimpleStringProperty(r);
		overview = o;
		isAdult = a;
		prodCo = p;

		genres = new String[g.length];
		for (int k = 0; k < genres.length; k++) {
			genres[k] = g[k];
		}

		castList = new PersonHeader[cast.length];
		for (int j = 0; j < castList.length; j++) {
			castList[j] = cast[j];
		}
		crewList = new PersonHeader[crew.length];
		for (int l = 0; l < crewList.length; l++) {
			castList[l] = cast[l];
		}
	}
	
//	public Movie() {
//		movieHead = null;
//		releaseDate = null;
//		genres = null;
//		overview = null;
//		isAdult = false;
//		prodCo = null;
//
//		castList = null;
//		crewList = null;
//	}

	

	// getDetails accessors
	public ObservableValue<Number> getMovieID() {
		return movieHead.getID();
	}

	public ObservableValue<String> getTitle() {
		return movieHead.getTitle();
	}

	public ObservableValue<String> getReleaseDate() {
		return releaseDate;
	}

	public String getGenres() {
		String out = "";
		for (int i = 0; i < genres.length; i++) {
			if (i == genres.length - 1)
				out = out + genres[i];
			else
				out = out + genres[i] + ", ";
		}
		return out;

	}

	public String getOverview() {
		return overview;
	}

	public String getProdCo() {
		return prodCo;
	}

	public boolean getIsAdult() {
		return isAdult;
	}

	public MovieHeader getMovieHead() {
		return movieHead;
	}

	// getCredits
	public String getCastNames() {
		String out = "";
		for (int i = 0; i < castList.length; i++) {
			if (i == castList.length - 1)
				out = out + castList[i].getName();
			else
				out = out + castList[i].getName() + ", ";
		}
		return out;
	}

	public String getCrewNames() {
		String out = "";
		for (int i = 0; i < crewList.length; i++) {
			if (i == crewList.length - 1)
				out = out + crewList[i].getName();
			else
				out = out + crewList[i].getName() + ", ";
		}
		return out;
	}

	public String getMovie() {
		String out = "";

		out = this.getMovieID() + ", " + this.getTitle() + ", " + this.getReleaseDate() + ", " + "[" + this.getGenres()
				+ "]" + ", " + this.getOverview() + ", " + this.getIsAdult() + ", " + this.getProdCo() + "\n "
				+ this.getCastNames() + "\n" + this.getCrewNames();

		return out;
	}
}
