package hack.moviedb.data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class MovieHeader {

	private BooleanProperty checked = new SimpleBooleanProperty(false);
	
	private StringProperty title;
	private IntegerProperty id;
	private String role;
	private String posterImageURL;

	public MovieHeader() {
		title = null;
		id = new SimpleIntegerProperty(-1);
		role = null;
		posterImageURL = null;
	}

	public MovieHeader(String t, int i, String r, String imPath) {
		title = new SimpleStringProperty(t);
		id = new SimpleIntegerProperty(i);
		role = r;
		posterImageURL = imPath;
	}
	
	public MovieHeader(String t, int i, String imPath) {
		title = new SimpleStringProperty(t);
		id = new SimpleIntegerProperty(i);
		role = null;
		posterImageURL = imPath;
	}

	public ObservableValue<String> getTitle() {
		return title;
	}

	public ObservableValue<Number> getID() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getPosterImageURL() {
		return posterImageURL;
	}
	
    public BooleanProperty checkedProperty() {
        return this.checked;
    }

    public final boolean getChecked() {
        return this.checked.get();
    }

    public void setChecked(final java.lang.Boolean checked) {
        this.checked.set(checked);
    }
}
