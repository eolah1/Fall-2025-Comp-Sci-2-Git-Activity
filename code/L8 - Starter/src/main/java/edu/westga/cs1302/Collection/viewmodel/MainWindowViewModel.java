package edu.westga.cs1302.Collection.viewmodel;

import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainWindowViewModel {

    private StringProperty name;
    private ListProperty<Collection> displayCollections;
    private ObjectProperty<Collection> selectedCollection;
    private ListProperty<Comic> displayComics;
    private ObjectProperty<Comic> selectedComic;
    private StringProperty comicName;
    private ObjectProperty<Integer> issueNum;
    private Map<String, Comic> comicMap = new HashMap<>();

    public MainWindowViewModel() {
        this.name = new SimpleStringProperty("");
        this.displayCollections = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<>();
        this.displayComics = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedComic = new SimpleObjectProperty<>();
        this.comicName = new SimpleStringProperty("");
        this.issueNum = new SimpleObjectProperty<>(0);
        
        this.selectedCollection.addListener((obs, oldCollection, newCollection) -> {
            if (newCollection != null) {
                this.displayComics.set(newCollection.getComics());
            } else {
                this.displayComics.set(FXCollections.observableArrayList());
            }
        });
    }

    public StringProperty getName() { 
    	return this.name; 
    }
    
    public ListProperty<Collection> getDisplayCollections() { 
    	return this.displayCollections; 
    }
    
    public ObjectProperty<Collection> getSelectedCollections() { 
    	return this.selectedCollection; 
    }
    
    public ListProperty<Comic> getDisplayComics() { 
    	return this.displayComics;
    }
    
    public ObjectProperty<Comic> getSelectedComic() { 
    	return this.selectedComic; 
    }
    
    public StringProperty getComicName() { 
    	return this.comicName; 
    }
    
    public ObjectProperty<Integer> getIssueNum() { 
    	return this.issueNum; 
    }

    public void addCollection() {
        String newName = this.name.get();
        if (newName != null && !newName.isEmpty()) {
            boolean exists = this.displayCollections.stream()
                                .anyMatch(c -> c.getName().equals(newName));
            if (exists) {
                return;
            }
            Collection item = new Collection(newName);
            this.displayCollections.add(item);
            this.name.set("");
        }
    }

    public void removeCollection() {
        Collection selected = this.selectedCollection.get();
        if (selected != null) {
            this.displayCollections.remove(selected);
            this.displayComics.set(FXCollections.observableArrayList());
        }
    }
    
    public void addComic() {
        String title = this.comicName.get();
        Integer issue = this.issueNum.get();

        if (title == null || title.isBlank() || issue == null || issue <= 0) {
            return;
        }

        Collection selected = this.selectedCollection.get();
        if (selected == null) {
            return;
        }

        Comic newComic = new Comic(title.trim(), issue);
        if (!selected.getComics().contains(newComic)) {
            selected.addComic(newComic);
            
            String key = newComic.getComicName().toLowerCase() + "#" + newComic.getIssueNum();
            this.comicMap.put(key, newComic);
        }

        this.displayComics.set(selected.getComics());

        this.comicName.set("");
        this.issueNum.set(0);
    }

    public void removeComic() {
        Collection selected = this.selectedCollection.get();
        Comic comic = this.selectedComic.get();

        if (selected != null && comic != null) {
            selected.removeComic(comic);
            this.displayComics.set(selected.getComics());
        }
    }
    public void addComic(Comic comic) {
        if (comic != null) {
            String key = comic.getComicName().toLowerCase() + "#" + comic.getIssueNum();
            this.comicMap.put(key, comic);
            this.displayComics.add(comic);
        }
    }
 
	public Comic searchComic(String title, int issue) {
		if (title == null) {
			return null;
		}
		
		String key = title.toLowerCase() + "#" + issue;
        return this.comicMap.get(key);
	}
}