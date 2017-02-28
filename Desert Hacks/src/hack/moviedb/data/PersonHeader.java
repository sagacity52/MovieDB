package hack.moviedb.data;

public class PersonHeader {

	private String name;
	private int id;
	private String role;
	private String profileImageURL;

	public PersonHeader() {
		name = null;
		id = -1;
		role = null;
		profileImageURL = null;
	}

	public PersonHeader(String n, int i, String r, String imPath) {
		name = n;
		id = i;
		role = r;
		profileImageURL = imPath;
	}

	public PersonHeader(String n, int i, String imPath) {
		name = n;
		id = i;
		role = null;
		profileImageURL = imPath;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}
}
