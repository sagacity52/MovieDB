package hack.moviedb.data;

import java.util.LinkedList;

import javafx.beans.value.ObservableValue;

public class MovieList {

	private LinkedList<Movie> movieList;
	private int searchIndex;
	
	public MovieList(){
		movieList = new LinkedList<Movie>();
		searchIndex = -1;
	}
	
	public LinkedList<Movie> getMovieList(){
		return movieList;
	}
	
	public boolean searchMovieList(Movie movie){
		boolean flag = false;
		for(int m = 0; m < movieList.size(); m++){
			
			if(movieList.get(m).equals(movie)){
				
				flag = true;
				searchIndex = m;
				break;
			}
			else{
				searchIndex = -1;
				flag = false;
			}
		}
		
		return flag;
	}
	
	public boolean searchMovieList(String title){
		boolean flag = false;
		for(int n = 0; n < movieList.size(); n++){
			System.out.println("test1");
			if(movieList.get(n).getTitle().equals(title)){
				System.out.println("test2");
				flag = true;
				searchIndex = n;
				break;
			}
			else{
				searchIndex = -1;
				flag = false;
			}
		}
		
		return flag;
	}
	
	public boolean addMovieToList(Movie movie){
		if(!this.searchMovieList(movie)){
			return movieList.add(movie);
		}
		else
			//already in list
			return false;
	}
	
	public boolean deleteMovieFromList(Movie movie){
		if(this.searchMovieList(movie)){
			return movieList.remove(movie);
		}
		else
			//not in list
			return false;
	}
	
	public Movie retrieveMovie(String title){
		if(this.searchMovieList(title)){
			System.out.println("test3");
			return movieList.get(searchIndex);
		}
		else{
			//not in list
			return null;
		}
	}
	
	public Movie retrieveMovie(int i){
		return movieList.get(i);
	}
	
	public int getSize(){
		return movieList.size();
	}
	
	
	
}
