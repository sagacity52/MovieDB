package hack.moviedb.data;

public class Movie {

	//getDetails 
	private int movieID;
	private String imageID;
	private String ogTitle;
	private String releaseDate;
	private String[] genres;
	private String overview;
	private boolean isAdult;
	private String prodCo;
	
	public Movie() {
		movieID = -1;
		imageID = null;
		ogTitle = null;
		releaseDate = null;
		genres = null;
		overview = null;
		isAdult = false;
		prodCo = null;
	}
	
	public Movie(int m, String i, String t, String r, String[] g, String o, boolean a, String p){
		movieID = m;
		imageID = i;
		ogTitle = t;
		releaseDate = r;
		overview = o;
		isAdult = a;
		prodCo = p;
		
		genres = new String[g.length];
		for(int k = 0; k < genres.length; k++){
			genres[k] = g[k];
		}
	}
	
	//getDetails accessors
	public int getMovieID(){
		return movieID;
	}
	public String getImageID(){
		return imageID;
	}
	
	public String getTitle(){
		return ogTitle;
	}
	
	public String getReleaseDate(){
		return releaseDate;
	}
	
	public String getGenres(){
		String out = "";
		for(int i = 0; i < genres.length; i++){
			if(i == genres.length - 1)
				out = out + genres[i];
			else
				out = out + genres[i] + ", ";
		}
		return out;
		
	}
	
	public String getOverview(){
		return overview;
	}
	
	public String getProdCo(){
		return prodCo;
	}
	
	public boolean getIsAdult(){
		return isAdult;
	}
	
	public String getMovie(){
		 String out = "";
		 
		 out = this.getMovieID() + ", " +
				 this.getTitle() + ", " +
				 this.getReleaseDate() + ", " +
				 "[" + this.getGenres() + "]" + ", " +
				 this.getOverview() + ", " +
				 this.getIsAdult() + ", " +
				 this.getProdCo();
		 
		 return out;				 
	}
}
