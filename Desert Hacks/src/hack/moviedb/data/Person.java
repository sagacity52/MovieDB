package hack.moviedb.data;

public class Person {

	private PersonHeader personHead;
	private String bday;
	private String dday;
	private String gender;
	private String bio;
	private String birthplace;
	private MovieHeader[] starredList;
	private MovieHeader[] crewedList;

	public Person() {

		personHead = null;
		bday = null;
		dday = null;
		gender = null;
		bio = null;
		starredList = null;
		crewedList = null;
		birthplace = null;
	}

	public Person(PersonHeader p, String b, String d, String g, String biography, String bplace, MovieHeader[] slist,
			MovieHeader[] clist) {
		personHead = p;
		bday = b;
		dday = d;
		gender = g;
		bio = biography;
		birthplace = bplace;

		starredList = new MovieHeader[slist.length];
		for (int i = 0; i < slist.length; i++) {
			starredList[i] = slist[i];
		}

		crewedList = new MovieHeader[clist.length];
		for (int i = 0; i < clist.length; i++) {
			crewedList[i] = clist[i];
		}

	}

	public String getName() {
		return personHead.getName();
	}

	public String getBDay() {
		return bday;
	}

	public String getDDay() {
		return dday;
	}

	public String getGender() {
		return gender;
	}

	public String getBio() {
		return bio;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public PersonHeader getPersonHead() {
		return personHead;
	}

	public String getStarredList() {
		String out = "";
		for (int i = 0; i < starredList.length; i++) {
			if (i == starredList.length - 1)
				out = out + starredList[i].getTitle();
			else
				out = out + starredList[i].getTitle() + ", ";
		}
		return out;
	}

	public String getCrewedList() {
		String out = "";
		for (int i = 0; i < crewedList.length; i++) {
			if (i == crewedList.length - 1)
				out = out + crewedList[i].getTitle();
			else
				out = out + crewedList[i].getTitle() + ", ";
		}
		return out;
	}
}
