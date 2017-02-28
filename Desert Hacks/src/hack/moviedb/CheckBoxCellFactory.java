package hack.moviedb;

import hack.moviedb.data.Movie;
import hack.moviedb.data.MovieHeader;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

public class CheckBoxCellFactory implements Callback<Object, Object> {
    @Override
    public TableCell<MovieHeader, Boolean> call(Object param) {
        CheckBoxTableCell<MovieHeader,Boolean> checkBoxCell = 
        		new CheckBoxTableCell<MovieHeader, Boolean>();
        return checkBoxCell;
    }
}